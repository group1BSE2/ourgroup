package git;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import core.Call_URL;
import core.CsvWriter;
import core.JSONUtils;
import picks.Pick_GeneralNext;
import util.Constants;

public class InheritedCommits implements Runnable {
	
	int task, start, end, ct;
	String file = "";

	InheritedCommits(int start, int end, int task, int ct) {
		this.end = end;
		this.start = start;
		this.task = task;
		this.ct = ct;
	}

	public void run() {
		
		String fileOld = "/Users/businge/Documents/000emse2020/00Dataset/npm_variants_1.xlsx";
		String file1 = "/Users/businge/Documents/000emse2020/00Dataset/inherited_commits/inherited_" + task + ".csv";
		
		Object[] datas = null;
		Object[] numbers = null;
		ArrayList<Object[]> allobjD = new ArrayList<Object[]>();
		
		try {
//			pick(String file, int sheetNum, int cellNumber, int rowNum)
			List<String> mlv = Pick_GeneralNext.pick(fileOld, 0, 0, 1);
			List<String> fv = Pick_GeneralNext.pick(fileOld, 0, 1, 1);

			List<String> forkDate = Pick_GeneralNext.pick(fileOld, 0, 2, 1);


			datas = new Object[] { "MLV", "FV", "InheritedCommits" };
			allobjD.add(datas);


			for (int i1 = start; i1 < end; i1++) {
//				this is for integration from mlv to fv
				System.out.println("Task-"+task+ " "+ i1 + " -- " + mlv.get(i1) + " : " + fv.get(i1));
				
				int startCommits = 0;
				
				JSONParser parser = new JSONParser();
				int p = 1;

				try {
					// control to break out of the infinite loop
					while (true) {
						if (ct >= (Constants.getToken().length)) {// the the index for the tokens array...
							ct = 0; // go back to the first index......
						}

//						String mlv_url = Call_URL.callURL("https://api.github.com/repos/" + variant1 + "/pulls?page=" + p
//								+ "&per_page=100&state=closed&access_token="+ token[ct++]);
						String fv_url = Call_URL.callURL1(
								"https://api.github.com/repos/" + fv.get(i1) + "/commits?page=" + p + "&per_page=100&until=" + forkDate.get(i1),
								Constants.getToken()[ct++]);
						if (JSONUtils.isValidJSON(fv_url) == false) {///

							System.out.println("Repo not found");
							break;
						}
						JSONArray jsonArry = (JSONArray) parser.parse(fv_url);
						if (jsonArry.toString().equals("[]")) {
							break;
						}
						startCommits += jsonArry.size();
						p++;
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				
				numbers = new Object[] {i1, mlv.get(i1), fv.get(i1), startCommits};
				allobjD.add(numbers);

				
				CsvWriter.csvWriter(allobjD, file1);
				System.out.println();	
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}
}
