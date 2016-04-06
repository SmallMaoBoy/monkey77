/**
 * @date:创建时间：2016-4-2下午5:06:39
 * @author:mao
 * 
 */
package com.monkey77.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.taglibs.standard.extra.spath.Path;

import com.monkey77.service.IGoodService;
import com.monkey77.service.IUserService;
import com.monkey77.test.utils.TestImageCompress;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author mao
 * @time 创建时间 2016-4-2下午5:06:39
 * 
 */
public class UploadAction extends ActionSupport{

	  private File file;
	    private String fileFileName;
	    private String fileFileContentType;
	    private Map<String,Object> map ; // 0格式错误 1成功(文件路径)  2失败
	    private String filePath;
	    private int type;//0代表用户头像1代表商品首页图标2代表商品轮播图3代表商品详情图
	    private int userId;
	    private IUserService userService;
	    private int goodId;
	    private IGoodService goodService;
	    
	    public IGoodService getGoodService() {
			return goodService;
		}

		public void setGoodService(IGoodService goodService) {
			this.goodService = goodService;
		}

		public int getGoodId() {
			return goodId;
		}

		public void setGoodId(int goodId) {
			this.goodId = goodId;
		}

		public IUserService getUserService() {
			return userService;
		}

		public void setUserService(IUserService userService) {
			this.userService = userService;
		}

		public int getType() {
			return type;
		}

		public void setType(int type) {
			this.type = type;
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public String getFilePath() {
	        return filePath;
	    }

	    public void setFilePath(String filePath) {
	        this.filePath = filePath;
	    }


	    public Map<String, Object> getMap() {
			return map;
		}

		public void setMap(Map<String, Object> map) {
			this.map = map;
		}

		public File getFile() {
	        return file;
	    }

	    public void setFile(File file) {
	        this.file = file;
	    }

	    public String getFileFileName() {
	        return fileFileName;
	    }

	    public void setFileFileName(String fileFileName) {
	        this.fileFileName = fileFileName;
	    }

	    public String getFileFileContentType() {
	        return fileFileContentType;
	    }

	    public void setFileFileContentType(String fileFileContentType) {
	        this.fileFileContentType = fileFileContentType;
	    }

	    //上传图片
	    @SuppressWarnings("deprecation")
	    @Override
	    public String execute() throws Exception {
	    	map=new HashMap<String,Object>();
	    	String subPath="";
	        if(type==0){
	        	subPath="/"+"user"+"/"+userId;
	        }else{
	        	subPath="/"+"good"+"/"+goodId;
	        }
	        String path = ServletActionContext.getRequest().getRealPath("/upload"+subPath);
	        String compressPath = ServletActionContext.getRequest().getRealPath("/mobile"+subPath);
	        File file = new File(path); // 判断文件夹是否存在,如果不存在则创建文件夹
	        if (!file.exists()) {
	            file.mkdirs();
	        }
	        File compressFile=new File(compressPath);
	        if (!compressFile.exists()) {
	        	compressFile.mkdirs();
	        }
	        String[] fileSuffix = new String[] { ".exe" };// 禁止文件
	        try {
	            File f = this.getFile();
	            // 判断文件格式
	            for (int i = 0; i < fileSuffix.length; i++) {
	                if (fileFileName.endsWith(fileSuffix[i])) {
	                    map.put("statusCode","2");
	                    return ERROR;
	                }
	            }
	            FileInputStream inputStream = new FileInputStream(f);
	            FileOutputStream outputStream = new FileOutputStream(path + "\\"
	                    + fileFileName);
	            byte[] buf = new byte[1024];
	            int length = 0;
	            while ((length = inputStream.read(buf)) != -1) {
	                outputStream.write(buf, 0, length);
	            }
	            inputStream.close();
	            outputStream.flush();
	            TestImageCompress.saveMinPhoto(f.getAbsolutePath(), compressPath+ "\\"+fileFileName, 139, 0.9d);
	            switch(type){
	            	case 0:userService.updateUserPicUrl(userId, "upload"+subPath+"/"+fileFileName);break;
	            	case 1:goodService.updateGoodPic(goodId,"upload"+subPath+"/"+fileFileName);break;
	            	case 2:goodService.addGoodPic(goodId, "upload"+subPath+"/"+fileFileName, 0);break;
	            	case 3:goodService.addGoodPic(goodId, "upload"+subPath+"/"+fileFileName, 1);break;
	            }
	            map.put("statusCode","0");
	            map.put("picUrl", "upload"+subPath+"/"+fileFileName);
	        } catch (Exception e) {
	            e.printStackTrace();
	            map.put("statusCode","1");
	        }
	        return SUCCESS;
	    }

	    public String download() {
	        String path = filePath;
	        HttpServletResponse response = ServletActionContext.getResponse();
	        try {
	            // path是指欲下载的文件的路径。
	            File file = new File(path);
	            // 取得文件名。
	            String filename = file.getName();
	            // 取得文件的后缀名。
	            String ext = filename.substring(filename.lastIndexOf(".") + 1)
	                    .toUpperCase();

	            // 以流的形式下载文件。
	            InputStream fis = new BufferedInputStream(new FileInputStream(path));
	            byte[] buffer = new byte[fis.available()];
	            fis.read(buffer);
	            fis.close();
	            // 清空response
	            response.reset();
	            // 设置response的Header
	            String filenameString = new String(filename.getBytes("gbk"),
	                    "iso-8859-1");
	            response.addHeader("Content-Disposition", "attachment;filename="
	                    + filenameString);
	            response.addHeader("Content-Length", "" + file.length());
	            OutputStream toClient = new BufferedOutputStream(response
	                    .getOutputStream());
	            response.setContentType("application/octet-stream");
	            toClient.write(buffer);
	            toClient.flush();
	            toClient.close();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	        return null;
	    }
}
