package com.kh.practice.file.fileController;

import com.kh.practice.file.model.dao.FileDAo;

public class FileController {
	FileDAo fd = new FileDAo();
	
	//이름이 존재하는지 확인하는 코드작성
	public boolean checkName(String file) {
		return fd.checkName(file);
	}
	
	//파일 저장 로직 작성
	public void fileSave(String file, StringBuilder sb) {
		fd.fileSave(file, sb.toString());
	}
	
	//파일 열기
	public StringBuilder fileOpen(String file) {
		return fd.fileOpen(file);
	}
	
	//파일 수정
	public void fileEdit(String file, StringBuilder sb) {
		fd.fileEdit(file, sb.toString());
	}
	
}
