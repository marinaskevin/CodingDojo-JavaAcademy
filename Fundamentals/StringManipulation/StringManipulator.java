public class StringManipulator {
	public String trimAndConcat(String s1, String s2) {
		s1=s1.trim();
		s2=s2.trim();
		return s1.concat(s2);
	}
	public Integer getIndexOrNull(String s, char c) {
		int idx = s.indexOf(c);
		if(idx == -1) return null;
		return idx;
	}
	public Integer getIndexOrNull(String s, String ss) {
                int idx = s.indexOf(ss);
                if(idx == -1) return null;
                return idx;
	}
	public String concatSubstring(String s1, int a, int b, String s2) {
		String ss = s1.substring(a,b);
		return ss.concat(s2);
	}	
}
