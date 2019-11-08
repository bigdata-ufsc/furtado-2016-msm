package br.ufsc.msm.base;


public class Stop implements Comparable<Stop> {
	private int id;
	public Point centroid;
	public Interval time;
    public String type;
	public Stop(int id, Point centroid, Interval time, String type) {
		
		this.id = id;
		this.centroid = centroid;
		this.time = time;
		this.type = type;
	}
	
	public Stop(Stop s) {
		
		this.id = s.id;
		this.centroid = s.centroid;
		this.time = s.time;
		this.type = s.type;
	}
	
	public int compareTo(Stop obj) {
		
        if (this.time.getStartTime().before(obj.time.getStartTime())){
        	return -1;
        }  else if (this.time.getStartTime().after(obj.time.getStartTime())){
        	return 1;
        }
        return 0;
	}
	
}
