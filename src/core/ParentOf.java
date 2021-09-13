package core;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParentOf {
	
	public static String parent_of(String fv, String[] tokens, int ct) {
		String created_at = "";
		try {
			if (ct >= (tokens.length)) {/// the the index for the tokens array...
				ct = 0; //// go back to the first index......
			}
			JSONParser parser = new JSONParser();
//			String repo_url = Call_URL.callURL("https://api.github.com/repos/" + fv + "?access_token=" + tokens[ct]);
			String repo_url = Call_URL.callURL1("https://api.github.com/repos/" + fv , tokens[ct]);
			ct++;
			JSONObject jsonObj = (JSONObject) parser.parse(repo_url);
			created_at = (String) jsonObj.get("created_at");
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return created_at;
	}

}
