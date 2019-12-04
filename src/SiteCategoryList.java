import java.util.HashSet;

public class SiteCategoryList extends SiteCategory{ //extends맞나
   
   public static void main(String[] args) {

   //일반
   HashSet geneSet = new HashSet();
   geneSet.add("사람만이");
   geneSet.add("네이버");
   geneSet.add("유투브");
   geneSet.add("구글");
   
   //정보
   HashSet infoSet = new HashSet();
   infoSet.add("정보1");
   infoSet.add("정보2");
   infoSet.add("정보3");
   infoSet.add("정보4");
   
   //포털
   HashSet portSet = new HashSet();
   infoSet.add("포털1");
   infoSet.add("포털2");
   infoSet.add("포털3");
   infoSet.add("포털4");
   
   //학교
   HashSet univSet = new HashSet();
   univSet.add("학교1");
   univSet.add("학교2");
   univSet.add("학교3");
   univSet.add("학교4");
   
   }
}


//일반 정보 포털 학교