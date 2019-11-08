package br.ufsc.msm;

import br.ufsc.msm.base.SemanticTrajectory;
import br.ufsc.msm.base.Stop;
import br.ufsc.msm.util.Distance;

public class MSM {

	private double spaceThreshold;
	private double timeThreshold;
	private double semanticThreshold;

	private double bScore[];
	
	public MSM(double spaceThreshold, double timeThreshold,
			double semanticThreshold) {
		this.spaceThreshold = spaceThreshold;
		this.timeThreshold = timeThreshold;
		this.semanticThreshold = semanticThreshold;
	}

	public double getMSMDistance(SemanticTrajectory A, SemanticTrajectory B) {
		int n = A.size();
		int m = B.size();
		
		bScore = new double[m];
		
		for (int j = 0; j < m; j++) {
			bScore[j]=0.0;
		}
	
		double score = 0.0;
		double maxScore = 0.0;
		double parityAB = 0.0;

		for (int i = 0; i < n; i++) {
			score = 0.0;
			maxScore = 0.0;
			
			for (int j = 0; j < m; j++) {
				score = score(A.get(i), B.get(j));

				if (score>=maxScore){
					maxScore=score;
					bScore[j] = maxScore>bScore[j] ? maxScore : bScore[j];
				}	
			}
			parityAB += maxScore;
		}
		
		double parityBA = 0.0;
		for (int j = 0; j < m; j++) {	
			parityBA+=bScore[j];
		}

		double similarity = (parityAB + parityBA) / (n + m);

		return similarity;
	}

	public double score(Stop p, Stop q) {
		double result = 0.0;

		
		double resultTime = (Distance.timeDistance(p.time, q.time) <= timeThreshold) ? 1.0/3.0 : 0;
		double resultSpace = (Distance.euclideanDistance(p.centroid, q.centroid) <= spaceThreshold) ? 1.0/3.0 : 0;
		double resultSemantic = (Distance.semanticDistance(p.type, q.type) <= semanticThreshold) ? 1.0/3.0 : 0;
		result=resultSpace+resultTime+resultSemantic;
		
		return result;
		
	}
}
