
public class Main {
	StartLogin startLogin;
	SiteInfo siteInfo;
	
	Main() {
		
	}
	public static void main(String[] args) {
		Main main = new Main();
		main.startLogin = new StartLogin();
		main.startLogin.setMain(main);
	}
	public void showSiteInfo() {
		startLogin.dispose();
		this.siteInfo = new SiteInfo();
	}

}
