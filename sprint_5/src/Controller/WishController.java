package Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import Model.Modelisable;
import Model.Wish;
import Utilitaires.CSV;

/**
 * Controller class for Wish and PanelWish class
 * @author Groupe 1B2
 * @version Sprint 4
 */
public class WishController extends PanelController {
	
	/**
	 * Create or read the file containing the wishes
	 * @param groupe Group ID of the group which has the wishes
	 */
	public WishController(String groupe) {
		super("data\\groupe"+groupe+"_voeux2014_2015.csv");
	}

	/* (non-Javadoc)
	 * @see Controller.PanelController#buildData()
	 */
	@Override
	protected void buildData() {
		
		File file = new File(this.filepath);
		
		ArrayList<Modelisable> list = new ArrayList<Modelisable>();
		
		if(!file.exists()){
			try {
				CSV.write(new ArrayList<Modelisable>(),this.filepath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(String[] entry : CSV.read("data\\sujets2014_2015.csv")) {
				System.out.println("new "+new Wish(entry[0], entry[1], entry[2], ""));
				
				this.data.add(new Wish(entry[0], entry[1], entry[2], ""));
			}
			
			try {
				CSV.write(data,filepath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
		
			for(String[] entry : CSV.read(filepath)) {
				System.out.println("new "+new Wish(entry[0], entry[1], entry[2], entry[3]));
				
				this.data.add(new Wish(entry[0], entry[1], entry[2], entry[3]));
			}
			
		}
		
	}

	/* (non-Javadoc)
	 * @see Controller.PanelController#addDataById(java.lang.String)
	 */
	@Override
	public void addDataById(String id) {
		// TODO Auto-generated method stub
		
	}

}