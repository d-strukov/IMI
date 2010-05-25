package lt.ktu.dstrukov.frontend.beans;

import javax.faces.context.FacesContext;

import lt.ktu.dstrukov.commons.OptimizationParameters;

import org.apache.myfaces.custom.fileupload.UploadedFile;

public class WizardBean {

	private enum Step {
		Welcome, Upload, Params, Progress, Resuts;
	};

	private static Step step = Step.Welcome;
	private UploadedFile dataFile;

	public String next() {

		switch (step) {
		case Welcome:
			step = Step.Upload;
			return "upload";
		case Upload:
			try {
				dataFile.getBytes();
				dataFile.getContentType();
				dataFile.getName();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			step = Step.Params;
			return "params";
		case Params:
			FacesContext context = FacesContext.getCurrentInstance();
			DataBean data = (DataBean) context.getApplication().getELResolver()
					.getValue(context.getELContext(), null, "dataBean");

			OptimizationParameters params = new OptimizationParameters();
			params.setIterationCount(data.getIterationCount());
			params.setStudentLessonOvertime(data.getHourOverflowPenalty());
			params.setStudentWindows(data.getStudentPenalty());
			params.setTeacherWindows(data.getTeacherPenalty());
			params.setTeacherAtDayOff(data.getTeacherOffPenalty());

			CentralBean central = (CentralBean) context.getExternalContext()
					.getApplicationMap().get("centralBean");
			if (central == null)
				central = (CentralBean) context.getApplication()
						.getELResolver().getValue(context.getELContext(), null,
								"centralBean");

			try {
				central.getCentral().setOptimizationParameters(params);
				central.getCentral().initializeData(dataFile.getInputStream());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			step = Step.Progress;
			return "progress";
		case Progress:
			context = FacesContext.getCurrentInstance();
			central = (CentralBean) context.getExternalContext()
					.getApplicationMap().get("centralBean");
			if (central == null)
				central = (CentralBean) context.getApplication()
						.getELResolver().getValue(context.getELContext(), null,
								"centralBean");

			step = Step.Resuts;
			return "results";
		case Resuts:
			step = Step.Welcome;
			return "welcome";

		default:
			step = Step.Welcome;
			return "welcome";
		}

	}

	public UploadedFile getDataFile() {
		return dataFile;
	}

	public void setDataFile(UploadedFile dataFile) {
		this.dataFile = dataFile;
	}

}
