package io.easyecom;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class FileReaderInJava {
	
	//Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "F://temp//";
    private Gson gson = new GsonBuilder().create();
    
	@PostMapping("/uploadFile")
	public String showUploadForm(@RequestParam("file") MultipartFile[] file,
            Model model, HttpServletRequest req)
	{
		
		if (file.length == 0) {
            model.addAttribute("message", "Please select a file to upload");
            return "result";
        }

        try {

        	List<List<String>> ans = new ArrayList<>();
        	for (int i = 0; i < file.length; i++) {
        		// Get the file and save it somewhere
                byte[] bytes = file[i].getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + file[i].getOriginalFilename());
                Files.write(path, bytes);

                String completeData = new String(bytes);
                String[] rows = completeData.split("\r\n");
                
                for (int row = 1; row < rows.length; row++) {
                	
                	List<String> answ = new ArrayList<>();
                	String[] columns = rows[row].split(",");
                	if (columns.length < 6) {
                    	System.out.println("Not proper data");
                    }

                    String orderNumber = columns[0];
                    //int transferredAmount = Integer.parseInt(columns[3]);
                    int totalMarketCharges = Integer.parseInt(columns[4]) + 
                    		Integer.parseInt(columns[5]) +  Integer.parseInt(columns[6]);
                    
                    int costPrice =  Integer.parseInt(columns[2]);
                    int salePrice =  Integer.parseInt(columns[1]);
                    int profitOrLoss = salePrice - costPrice;
                    
                    float percentage = ((float) profitOrLoss)/costPrice;
                    percentage *= 100;
                    
                    answ.add(orderNumber);
                    answ.add(new Float(percentage).toString());
                    answ.add(columns[3]);
                    answ.add(new Integer(totalMarketCharges).toString());
                    ans.add(answ);
                }
                
        	}
        	
        	
        	String jsonInString = gson.toJson(ans);
			model.addAttribute("data", jsonInString);
        	
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return "result";
	}
}
