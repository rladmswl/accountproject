import javax.swing.JFrame;


public class SiteInfo extends JFrame {
   
	private String siteName;
	private String url;
	private String id;
	private String pw;
	
	public SiteInfo(String siteName, String url, String id, String pw) {
		this.siteName = siteName;
		this.url = url;
		this.id = id;
		this.pw = pw;
	}
	
	String getSiteName() {
		return siteName;
	}
	String getUrl() {
		return url;
	}
	String getId() {
		return id;
	}
	String getPw() {
		return pw;
	}
	
	void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	void setUrl(String url) {
		this.url = url;
	}
	void setId(String id) {
		this.id = id;
	}
	void setPw(String pw) {
		this.pw = pw;
	}
	
	public boolean equals(Object o) {
		if(o instanceof SiteInfo) {
			SiteInfo t = (SiteInfo) o;
			return url.equals(t.url);
		}
		return false;
	}
	public int hashCode() {
		return url.hashCode();
	}
 

} 