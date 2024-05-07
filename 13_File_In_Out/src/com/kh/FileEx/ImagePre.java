package com.kh.FileEx;

import java.io.*;

public class ImagePre {
//바탕화면에 이미지폴더 / 동물이름.txt 파일 만들어준 후
	//동물이름 소 고양이 돼지 토끼 호랑이 이름을 \n 작성해서 만들어주고
	//동물이름을 만들어준 다음에
	//좋아하는 동물이름으로 폴더 이름 변경한 다음
	//삭제하기

	public static void main(String[] args) {
		//바탕화면에 폴더만들기
		String 폴더경로 = "c:/Users/user1/Desktop/이미지폴더";
		
		File 폴더만들기 = new File(폴더경로); 
	
		if(폴더만들기.exists()) {
			System.out.println("폴더가 이미 존재합니다.");
		}else {
			폴더만들기.mkdir();
			System.out.println("폴더만들기 성공");
		}
	
		//동물이름txt 파일 생성후 동물이름 작성
		try {
			FileWriter 글쓰기 = new FileWriter(폴더만들기+"/동물이름.txt");
			
			글쓰기.write("소\n고양이\n돼지\n토끼\n호랑이");
			System.out.println("동물이름 파일에 이름이 작성되었습니다.");
			글쓰기.close();//항상 작업하던 파일을 닫아줄것
			
			//좋아하는 동물이름으로 폴더이름 변경
			//FileWriter는 글쓰는건 편리하거나 파일의 이름을 비교하거나 다른작업은 하기 어려움
			File 원본파일 = new File(폴더만들기+"/동물이름.txt");
			File 새로운이름= new File(폴더만들기+"/좋아하는동물이름.txt");
			
			if(원본파일.renameTo(새로운이름)) {
				System.out.println("파일 이름이 성공적으로 변경되었습니다.");
			}else {
				System.out.println("파일 이름 변경에 실패했습니다.");
			}
			
			//삭제하기
			//폴더 삭제 파일삭제
			//폴더 삭제를 할때 폴더 안에 파일이 존재한다면 폴더삭제가 되지 않음
			
			//폴더 안에 파일이 존재하는지 확인 후 폴더 안에 파일이 하나도 존재하지 않는다면 삭제
			//배열을 이용해서 파일 목록을 받고 파일 목록이 없다면 삭제
			
			File[] 파일목록 = 폴더만들기.listFiles();
			System.out.println("폴더 안에 파일 목록 보기: " + 파일목록);
			
			//for each문을 사용해서 배열 안에 목록 볼수잇음
			for(File f : 파일목록) {
				System.out.println(f.getName());
			}
			
			//삭제 
			원본파일.delete();
			새로운이름.delete();
			폴더만들기.delete();
			//만약 폴더가 열려잇거나 사용중이면 삭제가 안됨
			//폴더 안에 파일이 숨겨져 있을 경우
			//삭제 권한 문제
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("동물이름 작성하는데 문제가 발생했습니다.");
			e.printStackTrace();
		}
		

		/*
		File 텍스트파일 = new File("c:/Users/user1/Desktop/이미지폴더/동물이름.txt");
		
		if(텍스트파일.exists()) {
			System.out.println("파일이 이미 존재합니다.");
		}else {
			try {
				텍스트파일.createNewFile();
				System.out.println(텍스트파일.getName() + " 파일이 생성되었습니다.");
			} catch (IOException e) {
				System.out.println("파일 만들기 실패");
				e.printStackTrace();
			}
		}
		String 동물 = "동물이름.txt";
		
		try {
			FileWriter 글쓰기 = new FileWriter(동물, true);
			String 내용 = "\n소, 고양이, 돼지, 토끼, 호랑이";
			글쓰기.write(내용);
			글쓰기.close();
			System.out.println("글쓰기 완료");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		*/
	}
}
