package lt.ktu.dstrukov.frontend.ajax;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lt.ktu.dstrukov.frontend.beans.CentralBean;

import org.apache.tomcat.util.json.JSONObject;

public class AjaxPhaseListener implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8292826768135695830L;

	public void afterPhase(PhaseEvent event) {

		String viewId = event.getFacesContext().getViewRoot().getViewId();
		if (viewId.indexOf("Ajax") != -1) {

			try {
				String action[] = viewId.split("[.]");
				handleAjaxRequest(event, action[1]);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	private void handleAjaxRequest(PhaseEvent event, String action) {
		FacesContext context = event.getFacesContext();
		HttpServletResponse response = (HttpServletResponse) context
				.getExternalContext().getResponse();
		Object object = context.getExternalContext().getRequest();
		if (!(object instanceof HttpServletRequest)) {
			// Only handle HttpServletRequests
			return;
		}

		HttpServletRequest request = (HttpServletRequest) object;

		CentralBean central = (CentralBean) context.getExternalContext()
				.getApplicationMap().get("centralBean");
		if (central == null)
			central = (CentralBean) context.getApplication().getELResolver()
					.getValue(context.getELContext(), null, "centralBean");

		if (action.equals("getData") && central != null) {
			try {

				JSONObject json = new JSONObject();
				json.put("action", action);

				json.put("nodeCount", central.getNodeCount());
				json.put("mainGraph", makeChartCharts(central.getMainValues()));
				Map<Integer, List<Integer>> map = central.getResultsAsInts();
				for (int key : map.keySet()) {
					json.put("node" + key, makeChartCharts(map.get(key)));
				}

				json.put("nodesBusy", central.isNodesBusy());

				response.setContentType("text/plain");
				response.setHeader("Cache-Control", "no-cache");

				response.getWriter().write(json.toString());
				event.getFacesContext().responseComplete();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (action.equals("getResult")) {

			response.addHeader("Content-Disposition",
					"attachment; filename=result.zip");

			try {
				central.getCentral().processResults(response.getOutputStream());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				response.getWriter().write("OK");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			event.getFacesContext().responseComplete();
		}

		if (action.equals("start") && central != null) {
			central.start();
			response.setContentType("text/plain");
			response.setHeader("Cache-Control", "no-cache");

			try {
				response.getWriter().write("OK");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			event.getFacesContext().responseComplete();
		}
	}

	private String makeChartCharts(List<Integer> res) {

		String ret = "http://chart.apis.google.com/chart?cht=lc&chs=250x100";

		int max = getMax(res);
		int maxAxe = (int) (max + 0.03 * max);

		int min = getMin(res);
		int minAxe = (int) (min - 0.03 * min);

		ret += "&chxr=" + minAxe + "," + maxAxe;

		ret += "&chd=t:";

		String actuals = "";
		for (int r : res) {
			int val = (int) ((100D / (double) (maxAxe - minAxe)) * (r - minAxe));
			ret += "" + val + ",";
			actuals += r + "; ";
		}

		return ret.substring(0, ret.length() - 1);

	}

	private int getMax(List<Integer> list) {

		int max = 0;
		for (int val : list)
			if (val > max)
				max = val;

		return max;

	}

	private int getMin(List<Integer> list) {

		int min = Integer.MAX_VALUE;
		for (int val : list)
			if (val < min)
				min = val;

		return min;

	}

	public void beforePhase(PhaseEvent arg0) {
		// not used, but implemented to satisfy compiler
	}

	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

	// Secure wrap the JSON to prevent hijacking
	public String secureWrapJSON(JSONObject json) {

		return "/*" + json + "*/";

	}
}
