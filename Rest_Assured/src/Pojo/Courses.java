package Pojo;

import java.util.List;

public class Courses {
	private List<API> api;
	private List<Mobile> mobile;
	private List<WebAutomation> webautomation;
	public List<API> getApi() {
		return api;
	}
	public void setApi(List<API> api) {
		this.api = api;
	}
	public List<Mobile> getMobile() {
		return mobile;
	}
	public void setMobile(List<Mobile> mobile){
		this.mobile = mobile;
	}
	public List<WebAutomation> getWebautomation() {
		return webautomation;
	}
	public void setWebautomation(List<WebAutomation> webautomation) {
		this.webautomation = webautomation;
	}

}
