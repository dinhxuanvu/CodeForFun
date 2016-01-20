/* 
 * CarRadio.java 
 * 
 * Version: 
 *     $Id: 
 * 
 * Revisions: 
 *     $Log: 
 * 
 */

import java.util.*;

/*
 * 
 * A class represents an AM/FM car radio.
 * 
 * @author Vu Dinh (vxd9797)
 */

public class CarRadio {
	
	// Constant values for max and min volumes
	private static final int MAX_VOLUME = 20;
	private static final int MIN_VOLUME = 0;
	
	int volume = 0; // Initial volume
	int set = 0;	// Initial set value
	int preset = 0;	// Initial preset value
	int AMfreq = FreqBand.AM.minFreq(); // Initial AM frequency
	int FMfreq = FreqBand.FM.minFreq();	// Initial FM frequency
	
	String amfm = "AM"; // Initial AM/FM selection
	boolean power = false; // Initial power value
	boolean mute = false;	// Initial mute value
	
	int[][] presets = new int[5][4]; // 2D array for presets (5 presets with 2 channels for AM and FM
	
	StationData newStation;
	
	/*
	 * CarRadio constructor
	 */
	public CarRadio(StationData sd) {
		 newStation = sd;
		
		 presets[0][0] = FreqBand.AM.minFreq();
		 presets[0][1] = FreqBand.AM.minFreq();
		 
		 presets[0][2] = FreqBand.FM.minFreq();
		 presets[0][3] = FreqBand.FM.minFreq();
		 
		 presets[1][0] = FreqBand.AM.minFreq();
		 presets[1][1] = FreqBand.AM.minFreq();
		 
		 presets[1][2] = FreqBand.FM.minFreq();
		 presets[1][3] = FreqBand.FM.minFreq();
		 
		 presets[2][0] = FreqBand.AM.minFreq();
		 presets[2][1] = FreqBand.AM.minFreq();
		 
		 presets[2][2] = FreqBand.FM.minFreq();
		 presets[2][3] = FreqBand.FM.minFreq();
		 
		 presets[3][0] = FreqBand.AM.minFreq();
		 presets[3][1] = FreqBand.AM.minFreq();
		 
		 presets[3][2] = FreqBand.FM.minFreq();
		 presets[3][3] = FreqBand.FM.minFreq();
		 
		 presets[4][0] = FreqBand.AM.minFreq();
		 presets[4][1] = FreqBand.AM.minFreq();
		 
		 presets[4][2] = FreqBand.FM.minFreq();
		 presets[4][3] = FreqBand.FM.minFreq();
	}
	
	/*
	 * AM/FM selection
	 */
	public void amfmBth() {
		set = 0;
		if(amfm == "FM") {
			amfm = "AM";
		}
		else if (amfm == "AM") {
			amfm = "FM";
		}
	}
	
	/*
	 * Power ON or OFF
	 */
	public void powerBtn() {
		if (power == false) {
			power = true;
		}
		else {
			power = false;
		}
	}
	
	/*
	 * Sound ON or OFF (mute)
	 */
	public void muteBtn() {
		if (mute = false) {
			mute = true;
		}
		else {
			mute = false;
		}
	}
	
	/*
	 * Volume goes up one unit
	 */
	public void volumeUpBth() {
		if (volume < MAX_VOLUME) {
			volume++;
		}
	}
	
	/*
	 * Volume goes down one unit
	 */
	public void volumeDownBth() {
		if (volume > MIN_VOLUME) {
			volume--;
		}
	}

	/*
	 * AM/FM frequency increases by one unit
	 */
	public void tuneUpBth() {
		set = 0;
		  if (amfm == "FM") {
		   if (FMfreq >= FreqBand.FM.maxFreq()) {
		    FMfreq = FreqBand.FM.minFreq();
		   } 
		   else if (FMfreq < FreqBand.FM.maxFreq()) {
		    FMfreq += FreqBand.FM.spacing();
		   }
		  } 
		  else if (amfm == "AM") {
		   if (AMfreq >= FreqBand.AM.maxFreq()) {
		    AMfreq = FreqBand.AM.minFreq();
		   } 
		   else if (AMfreq < FreqBand.AM.maxFreq()) {
		    AMfreq += FreqBand.AM.spacing();
		   }
		  }
	}
	
	/*
	 * AM/FM frequency decreases by one unit
	 */
	public void tuneDownBtn() {
		  set = 0;
		  if (amfm == "FM"){
		   if (FMfreq <= FreqBand.FM.minFreq()){
		    FMfreq = FreqBand.FM.maxFreq();
		   } 
		   else if (FMfreq > FreqBand.FM.minFreq()) {
		    FMfreq -= FreqBand.FM.spacing();
		   }
		  } 
		  else if (amfm == "AM"){
		   if (AMfreq <= FreqBand.AM.minFreq()){
		    AMfreq = FreqBand.AM.maxFreq();
		   } 
		   else if (AMfreq > FreqBand.AM.minFreq()) {
		    AMfreq -= FreqBand.AM.spacing();
		   }
		  }
		 }
	
	/*
	 * Preset mode: 0 - Not read, 1 - Primary, 2 - Secondary 
	 */
	public void setBtn() {
		  if (set == 0) {
		   set = 1;
		  } 
		  else if (set == 1) {
		   set = 2;
		  } 
		  else if (set == 2 ) {
		   set = 0;
		  }
		 }
	
	/*
	 * Increasing the AM/FM frequency until the new station is found.
	 */
	public void seekUpBtn() {
		  set = 0;
		  if (amfm == "AM") {
		   if (AMfreq >= FreqBand.AM.maxFreq()) {
		    AMfreq = FreqBand.AM.minFreq();
		   } 
		   else if (AMfreq < FreqBand.AM.maxFreq()){
		    AMfreq += FreqBand.AM.spacing();
		   }
		   FreqBand newBand = FreqBand.valueOf(amfm);
		   String sd = newStation.lookupFreq(newBand, AMfreq);
		   if (sd == null) {
		    seekUpBtn();
		   } 
		  } 
		  
		  else if (amfm == "FM") {
		   if (FMfreq >= FreqBand.FM.maxFreq()) {
		    FMfreq = FreqBand.FM.minFreq();
		   } 
		   else if (FMfreq < FreqBand.FM.maxFreq()) {
		    FMfreq += FreqBand.FM.spacing();
		   }
		   FreqBand newBand = FreqBand.valueOf(amfm);
		   String sd = newStation.lookupFreq(newBand, FMfreq);
		   if (sd == null){
		    seekUpBtn();
		   } 
		  }
		 }
	
	/*
	 * Decreasing the AM/FM frequency until the new station is found.
	 */
	public void seekDownBtn() {
		  set = 0;
		  if (amfm == "AM") {
		   if (AMfreq <= FreqBand.AM.minFreq()){
		    AMfreq = FreqBand.AM.maxFreq();
		   } 
		   else if (AMfreq > FreqBand.AM.minFreq()){
		    AMfreq -= FreqBand.AM.spacing();
		   }
		   FreqBand newBand = FreqBand.valueOf(amfm);
		   String sd = newStation.lookupFreq(newBand, AMfreq);
		   if (sd == null){
		    seekDownBtn();
		   } 
		  } 
		  
		  else if (amfm == "FM") {
		   if (FMfreq <= FreqBand.FM.minFreq()){
		    FMfreq = FreqBand.FM.maxFreq();
		   } 
		   else if (FMfreq > FreqBand.FM.minFreq()){
		    FMfreq -= FreqBand.FM.spacing();
		   }
		   FreqBand newBand = FreqBand.valueOf(amfm);
		   String sd = newStation.lookupFreq(newBand, FMfreq);
		   if (sd == null){
		    seekDownBtn();
		   } 
		  }
		 }
	
	/*
	 * The first preset button. When the set is 0, the preset is not ready.
	 * When the set is 1, the preset is primary and when the set is 2, the present is secondary.
	 * The preset is 0 when it is on primary and preset is 1 when it is on secondary.
	 */
	public void preset1Btn(){
		if (amfm == "AM"){
			   if (set == 0 && preset == 0){
			    AMfreq = presets[0][0];
			    preset = 1;
			   } 
			   else if  (set == 0 && preset == 1) {
			    AMfreq = presets[0][1];
			    preset = 0;
			   }
			   if (set == 1){
			    presets[0][0] = AMfreq;
			    set = 0;
			   } 
			   else if (set == 2) {
			    presets[0][1] = AMfreq;
			    set = 0;
			   }
			  } 
		
		else if (amfm == "FM"){
			   if (set == 0 && preset == 0){
			    FMfreq = presets[0][2];
			    preset = 1;
			   } 
			   else if  (set == 0 && preset == 1) {
			    FMfreq = presets[0][3];
			    preset = 0;
			   }
			   if (set == 1){
			    presets[0][2] = FMfreq;
			    set = 0;
			   } 
			   else if (set == 2) {
			    presets[0][3] = FMfreq;
			    set = 0;
			   }
			  }
		 }
	
	/*
	 * The second preset button. The same functionality as first preset button.
	 */
	public void preset2Btn(){
		if (amfm == "AM"){
			   if (set == 0 && preset == 0){
			    AMfreq = presets[1][0];
			    preset = 1;
			   } 
			   else if  (set == 0 && preset == 1) {
			    AMfreq = presets[1][1];
			    preset = 0;
			   }
			   if (set == 1){
			    presets[1][0] = AMfreq;
			    set = 0;
			   } 
			   else if (set == 2) {
			    presets[1][1] = AMfreq;
			    set = 0;
			   }
			  } 
		
		else if (amfm == "FM"){
			   if (set == 0 && preset == 0){
			    FMfreq = presets[1][2];
			    preset = 1;
			   } 
			   else if  (set == 0 && preset == 1) {
			    FMfreq = presets[1][3];
			    preset = 0;
			   }
			   if (set == 1){
			    presets[1][2] = FMfreq;
			    set = 0;
			   } 
			   else if (set == 2) {
			    presets[1][3] = FMfreq;
			    set = 0;
			   }
			  }
		 }
	
	/*
	 * The third preset button. The same functionality as first preset button.
	 */
	public void preset3Btn(){
		if (amfm == "AM"){
			   if (set == 0 && preset == 0){
			    AMfreq = presets[2][0];
			    preset = 1;
			   } 
			   else if  (set == 0 && preset == 1) {
			    AMfreq = presets[2][1];
			    preset = 0;
			   }
			   if (set == 1){
			    presets[2][0] = AMfreq;
			    set = 0;
			   } 
			   else if (set == 2) {
			    presets[2][1] = AMfreq;
			    set = 0;
			   }
			  } 
		
		else if (amfm == "FM"){
			   if (set == 0 && preset == 0){
			    FMfreq = presets[2][2];
			    preset = 1;
			   } 
			   else if  (set == 0 && preset == 1) {
			    FMfreq = presets[2][3];
			    preset = 0;
			   }
			   if (set == 1){
			    presets[2][2] = FMfreq;
			    set = 0;
			   } 
			   else if (set == 2) {
			    presets[2][3] = FMfreq;
			    set = 0;
			   }
			  }
		 }
	
	/*
	 * The four preset button. The same functionality as first preset button.
	 */
	public void preset4Btn(){
		if (amfm == "AM"){
			   if (set == 0 && preset == 0){
			    AMfreq = presets[3][0];
			    preset = 1;
			   } 
			   else if  (set == 0 && preset == 1) {
			    AMfreq = presets[3][1];
			    preset = 0;
			   }
			   if (set == 1){
			    presets[3][0] = AMfreq;
			    set = 0;
			   } 
			   else if (set == 2) {
			    presets[3][1] = AMfreq;
			    set = 0;
			   }
			  } 
		
		else if (amfm == "FM"){
			   if (set == 0 && preset == 0){
			    FMfreq = presets[3][2];
			    preset++;
			   } 
			   else if  (set == 0 && preset == 1) {
			    FMfreq = presets[3][3];
			    preset = 0;
			   }
			   if (set == 1){
			    presets[3][2] = FMfreq;
			    set = 0;
			   } 
			   else if (set == 2) {
			    presets[3][3] = FMfreq;
			    set = 0;
			   }
			  }
		 }
	
	/*
	 * The fifth preset button. The same functionality as first preset button.
	 */
	public void preset5Btn(){
		if (amfm == "AM"){
			   if (set == 0 && preset == 0){
			    AMfreq = presets[4][0];
			    preset = 1;
			   } 
			   else if  (set == 0 && preset == 1) {
			    AMfreq = presets[4][1];
			    preset = 0;
			   }
			   if (set == 1){
			    presets[4][0] = AMfreq;
			    set = 0;
			   } 
			   else if (set == 2) {
			    presets[4][1] = AMfreq;
			    set = 0;
			   }
			  } 
		
		else if (amfm == "FM"){
			   if (set == 0 && preset == 0){
			    FMfreq = presets[4][2];
			    preset++;
			   } 
			   else if  (set == 0 && preset == 1) {
			    FMfreq = presets[4][3];
			    preset = 0;
			   }
			   if (set == 1){
			    presets[4][2] = FMfreq;
			    set = 0;
			   } 
			   else if (set == 2) {
			    presets[4][3] = FMfreq;
			    set = 0;
			   }
			  }
		 }
	
	/*
	 * Display the text user interface of the radio. The UI includes:
	 * Channel name, frequency, AM or FM, Volume and Preset
	 */
	 public ArrayList<String> display(){
		  ArrayList<String> output = new ArrayList<String>();
		  
		  if (power == false){
			   output.add("---------------------");
			   output.add("|                   |");
			   output.add("|                   |");
			   output.add("---------------------");
			  } 
		  else if (power == true) {
			   System.out.println("---------------------");
			   if (amfm == "AM"){
			     if (newStation.lookupFreq(FreqBand.valueOf(amfm), AMfreq) != null){
			      output.add("|  " + amfm + "   " + AMfreq + "  " + newStation.lookupFreq(FreqBand.valueOf(amfm), AMfreq) +" |");
			     } 
			     else if (newStation.lookupFreq(FreqBand.valueOf(amfm), AMfreq) == null){
			      output.add("|  " + amfm + "   " + AMfreq + "  ****  |");
			     }
			    if (mute == false){
			      if (set == 0){
			        output.add("|  Vol: " + volume + "           |");
			      } 
			      else if (set == 1 || set == 2) {
			       output.add("|  Vol: " + volume + "    " + "SET" + set + "   |");
			     } 
			      
			    } else if (mute == true){
			     if (set == 0){
			      
			       output.add("|  Vol: --          |");
			      }
			     else if (set == 1 || set == 2) {
			      output.add("|  Vol: --    " + "SET" + set + "  |");
			     }
			    }
			   } 
			   else if (amfm == "FM") {
			    double newFM = (double) FMfreq/1000;
			     if (newStation.lookupFreq(FreqBand.valueOf(amfm), FMfreq) != null){
			      output.add("|  " + amfm + "   " + newFM + "  " + newStation.lookupFreq(FreqBand.valueOf(amfm), FMfreq) +" |");
			     } 
			     else if (newStation.lookupFreq(FreqBand.valueOf(amfm), FMfreq) == null){
			      output.add("|  " + amfm + "   " + newFM + "  **** |");
			     }
			    if (mute == false){
			      if (set == 0){
			        output.add("|  Vol: " + volume + "           |");
			       }
			      else if (set == 1 || set == 2) {
			       output.add("|  Vol: " + volume + "     " + "SET" + set + "  |");
			      }
			    } 
			    else if (mute == true){
			     if (set == 0){
			       output.add("|  Vol: --          |");
			     } 
			     else if (set == 1 || set == 2) {
			      output.add("|  Vol: --    " + "SET" + set + "  |");
			     }
			    }
			   }
			   output.add("---------------------");
			  }
		  return output;
		 }
}
