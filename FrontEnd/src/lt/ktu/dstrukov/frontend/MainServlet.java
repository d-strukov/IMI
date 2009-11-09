package lt.ktu.dstrukov.frontend;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lt.ktu.dstrukov.optimizator.Optimizator;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServlet() {
		super();

	}

	Optimizator o = null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int action = -1;
		try {
			action = Integer.parseInt(request.getParameter("action"));

		} catch (Exception ex) {
		}

		switch (action) {
		case 0:
			if (o == null)
				StartTheProcess();
			break;
		case 1:
			if (o != null)
				UpdateTheCharts(response);
			break;

		default:
			break;
		}

	}

	private void UpdateTheCharts(HttpServletResponse response) {

		String ret = "http://chart.apis.google.com/chart?cht=lc&chs=250x100";
		List<Integer> res = o.getResults();

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

		try {
			response.getOutputStream()
					.print(ret.substring(0, ret.length() - 1));
			// response.getOutputStream().println("");
			// response.getOutputStream().println(actuals);
		} catch (IOException e) {
			e.printStackTrace();
		}
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

	private void StartTheProcess() {

		// Initialize Central

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// response.getOutputStream().print(i++);
	}

}
