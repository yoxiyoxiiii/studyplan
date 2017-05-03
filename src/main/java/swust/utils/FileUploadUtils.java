package com.swust.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件上传Utils
 * @author Administrator
 *
 */
public class FileUploadUtils {
	
	private static final String filePath="/WEB-INF/upload";
	//根据不同的系统 得到 不同 的 文件（夹）分割符(/)
	private static final String separator="\\";
	
	/**
	 * 单文件上传
	 * @param file
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	public static String doUpload(MultipartFile file, HttpServletRequest request) throws Exception{
		//文件真实存放位置
		String realPath = request.getServletContext().getRealPath(filePath);
		//原文件名
		String originalFilename = file.getOriginalFilename();
		//新文件名
		String newFileName = UUID.randomUUID().toString()+"_"+originalFilename;
		// 创建 两级目录 来 存放文件：../4/6/xxx.txt
		int hashCode = originalFilename.hashCode();
		int dir1=hashCode&0xf;//取 低4位
		int dir2=(hashCode&0xf0)>>4;// 取5-8位
		//重新定义存放路径
		String path = realPath+File.separator+dir1+File.separator+dir2;
		File target =new File(path,newFileName);
		if(!target.exists()){//文件夹不存在
			//创建文件夹和所有父文件夹
			target.mkdirs();
		}
		//保存 文件
		file.transferTo(target);
		//得到 保存文件的 相对路径。并返回
		String toSavePath=filePath+separator+newFileName;
		return toSavePath;
	}


}
