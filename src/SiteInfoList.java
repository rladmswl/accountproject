import java.util.HashSet;

public class SiteInfoList {

	HashSet<SiteInfo> infos = new HashSet<SiteInfo>();
	
	public void add(SiteInfo data) {
		infos.add(data);
	}
	public void delete(SiteInfo data) {
		infos.remove(data);
	}
	
	public HashSet<SiteInfo> getSiteInfo(){
		return infos;
	}
}
