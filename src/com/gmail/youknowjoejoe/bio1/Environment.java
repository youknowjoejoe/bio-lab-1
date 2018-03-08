package com.gmail.youknowjoejoe.bio1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Environment {
	
	private Individual[] individuals;
	private Random random;
	
	public Environment(int n, int seed){
		individuals = new Individual[n];
		for(int i = 0; i < n; i++){
			individuals[i] = new Individual();
		}
		
		random = new Random(seed);
	}
	
	public Environment(int n){
		individuals = new Individual[n];
		for(int i = 0; i < n; i++){
			individuals[i] = new Individual();
		}
		
		random = new Random();
	}
	
	public void tag(int n){
		List<Individual> sample = getSample(n);
		
		for(Individual ind: sample){
			ind.tag();
		}
	}
	
	public int countTaggedFrom(int n){
		List<Individual> sample = getSample(n);
		
		int count = 0; 
		for(Individual ind: sample){
			if(ind.isTagged()) count++;
		}
		
		return count;
	}
	
	public List<Individual> getSample(int n){
		List<Individual> sample = new ArrayList<Individual>();
		sample.addAll(Arrays.asList(individuals));
		while(sample.size() > n){
			sample.remove(random.nextInt(sample.size()));
		}
		return sample;
	}
	
	public static void main(String[] args){
		Environment env = new Environment(100);
		
		int tagged = 10;
		int countedTagged = 0;
		int recaptureValue = 15;
		int recaptures = 20;
		
		env.tag(tagged);
		
		for(int i = 0; i < recaptures; i++){
			int tempCountedTagged = env.countTaggedFrom(recaptureValue);
			countedTagged+=tempCountedTagged;
			System.out.println("captured: " + recaptureValue + " tagged: " + tempCountedTagged);
		}
		
		System.out.println("estimate of total population: " + ((double)(recaptureValue*recaptures*tagged))/((double)countedTagged) );
	}
}
