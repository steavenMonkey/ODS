package example.spring.boot.demo.yaml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class DogeService {
	@Autowired
	private DogeRepository dogerepository;
	
	@Autowired
	private DogeSettings dogeSettings;
	
	public boolean requiresDogeness(){
		if(dogeSettings.getWow() > 5 && dogeSettings.isVery() == true){
			return true;
		}
		return false;
	}
	
	
	public String leDoge(){
		return dogerepository.getData();
	}
}
