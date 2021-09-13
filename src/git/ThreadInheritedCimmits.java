package git;

import java.util.List;

import core.CSVReader;
import pr.IntegratedCommitsAll;

public class ThreadInheritedCimmits {
	
	public static void main(String[] args) throws Exception {


//		String file = "00Extension/Pairs_fv_mlv.csv";
		String file = "/Users/businge/Documents/000emse2020/00Dataset/npm_variants_1.csv";
		
		List<String> mlv = CSVReader.pickStr(file, 0, 1);
		
		int ct[] = {0, 3, 6, 9, 12, 15, 18, 21, 24, 27, 30};
		
		
//		for the repos npm_mlv_to_fv
		int start1 = 0, start2 = 1100, start3 = 2000, start4 = 3000, start5 = 4000, start6 = 5000, start7 = 6000; 
		int end1 = 1000, end2 = 2000, end3 = 3000, end4 = 4000, end5 = 5000, end6 = 6000, end7 = 7000; 
		
		int	start8 = 7000, start9 = 8000, start10 = 9000, start11 = 10000;
    	int	end8 = 8000, end9 = 9000, end10 = 10000, end11 = mlv.size();
		
//		for the repos of npm_fv_to_mlv
//		int start1 = 0, start2 = 2000, start3 = 4000, start4 = 6000, start5 = 8000, start6 = 10000; 
//		int end1 = 2000, end2 = 4000, end3 = 6000, end4 = 8000, end5 = 10000, end6 = mlv.size(); 
		
    	
//    	InheritedCommits task1=new InheritedCommits(start1, end1, 1, ct[0]);
//        Thread google_task1=new Thread(task1);
//        google_task1.start();
//        
//        InheritedCommits task2=new InheritedCommits (start2, end2, 2, ct[1]);
//        Thread google_task2=new Thread(task2);
//        google_task2.start();
//        
//        InheritedCommits task3=new InheritedCommits (start3, end3, 3, ct[2]);
//        Thread google_task3=new Thread(task3);
//        google_task3.start();
//        
//        InheritedCommits task4=new InheritedCommits (start4, end4, 4, ct[3]);
//        Thread google_task4=new Thread(task4);
//        google_task4.start();
//        
//        InheritedCommits task5=new InheritedCommits (start5, end5, 5, ct[4]);
//        Thread google_task5=new Thread(task5);
//        google_task5.start();
        
//        InheritedCommits task6=new InheritedCommits(start6, end6, 6, ct[5]);
//        Thread google_task6=new Thread(task6);
//        google_task6.start();
//        
//        InheritedCommits task7=new InheritedCommits (start7, end7, 7, ct[6]);
//        Thread google_task7=new Thread(task7);
//        google_task7.start();
//        
//        InheritedCommits task8=new InheritedCommits (start8, end8, 8, ct[7]);
//        Thread google_task8=new Thread(task8);
//        google_task8.start();
//        
        InheritedCommits task9=new InheritedCommits (start9, end9, 9, ct[8]);
        Thread google_task9=new Thread(task9);
        google_task9.start();
        
        InheritedCommits task10=new InheritedCommits (start10, end10, 10, ct[9]);
        Thread google_task10=new Thread(task10);
        google_task10.start();
        
        InheritedCommits task11=new InheritedCommits (start11, end11, 11, ct[10]);
        Thread google_task11=new Thread(task11);
        google_task11.start();
	}

}
