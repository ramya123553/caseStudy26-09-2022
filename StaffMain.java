package com.gl.caseStudy1;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StaffMain {

    public static Double totalCalculation (Applicant applicant) {
    	Double m1=applicant.getSubject1Mark();
		 Double m2=applicant.getSubjec2Mark();
		 Double m3=applicant.getSubject3Mark();
		 if (m1<50 || m2<50 || m3<50) {
			 return 0.0;
		 }
		 else {
			 Double total=m1+m2+m3;
			 return total;
		 }
	 }
    	 
	
	public static Double percentageCalculation (Double total) {
		 Double per= (total/300)*100;
		 DecimalFormat df = new DecimalFormat("0.00");
		 String persentage=df.format(per);
		 return Double.parseDouble(persentage) ;
	}
	public static void main(String[] args) {
		Integer id=100;
	
		Scanner sc=new Scanner(System.in);
		List<Applicant> applicantList=new ArrayList<Applicant>();
		System.out.println("Enter the num of Applicants:");
		Integer n=Integer.parseInt(sc.nextLine());
		//Applicant []applicantArr=new Applicant[n];
		for(int i=0;i<n;i++) {
			System.out.println("Enter the details:");
			String s = sc.nextLine();
			String str[]=s.split(",");
			String name = str[0];
			double subject1Mark=Double.parseDouble(str[1]);
			double subject2Mark=Double.parseDouble(str[2]);
			double subject3Mark=Double.parseDouble(str[3]);
			try {
				if(subject1Mark>100 || subject1Mark<0 || subject2Mark>100 || subject2Mark<0 || subject3Mark>100 || subject3Mark<0 ) {
					throw new MarksException("\nInvalid marks; should be between 0 and 100\n");
				}
			}
			catch (MarksException e) {
				System.out.println(e.getMessage());
				continue;
			}
			Applicant a=new Applicant(name,subject1Mark,subject2Mark,subject3Mark,0.0,0.0);
			a.setId(++id);
			Double total=totalCalculation(a);
			Double percentage=percentageCalculation(total);
			a.setTotal(total);
			if (total==0.0 || percentage<70.00)
				continue;
			a.setPercentage(percentage);
			applicantList.add(a);
	}
		System.out.println("Output format");
		applicantList.forEach((applicant)->System.out.println(applicant));
		}

	}