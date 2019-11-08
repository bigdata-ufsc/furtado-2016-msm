package br.ufsc.msm.base;

import java.sql.Timestamp;

public class Interval implements Comparable<Interval>{
	private Timestamp startTime;
	private Timestamp endTime;

	public Interval(Timestamp startTime, Timestamp endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public Timestamp getStartTime() {
		return startTime;
	}
	
	public Timestamp getEndTime() {
		return endTime;
	}
	


	public int compareTo(Interval obj) {
		
        if (this.startTime.before(obj.startTime)){
        	return -1;
        }  else if (this.startTime.after(obj.startTime)){
        	return 1;
        }
        return 0;
	}

}
