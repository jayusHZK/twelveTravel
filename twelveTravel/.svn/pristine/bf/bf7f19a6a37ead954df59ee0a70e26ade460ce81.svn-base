package com.travel.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.travel.po.Result;


@Controller
@RequestMapping("/file")
public class FileController {
	@ResponseBody
	@RequestMapping("/upload")
	public Result upload(@RequestParam("fileList") List<MultipartFile> fileList,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/html;charset=UTF-8");
		Result rs=new Result();
		if(fileList!=null&&!fileList.isEmpty()&&fileList.size()>0){//判断上传文件是否为空
			List<String> list=new ArrayList<String>();
			for (MultipartFile item : fileList) {
				String oldName=item.getOriginalFilename();//获取原始文件名
				String lastName=oldName.substring(oldName.lastIndexOf("."));//获取文件后缀名
				String path=request.getServletContext().getRealPath("/upload/");
				System.out.println(lastName);
				File filePath=new File(path);
				//判断是否存在此文件夹  如果没有则创建
				if(!filePath.exists()){
					filePath.mkdirs();
				}
				String newFileName=UUID.randomUUID()+lastName;//重命名文件  使用UUID保证不重复+后缀名
				
				try {
					////使用MultipartFile接口的方法完成文件上传到指定位置
					item.transferTo(new File(path,newFileName));
					list.add(newFileName);
					rs.setCode(200);
					rs.setMsg(list);
				} catch (Exception e) {
					rs.setCode(400);
				}
			}
			
		}else{
			rs.setCode(400);
		}
		return rs;
	}
}
