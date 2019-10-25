package com.teamknowlogy.testapi.business;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class Mutations {

	public boolean hasMutation (String [] dna) {
		return hasMutationByRow(dna) || hasMutationByCols(dna) || hasMutationByDiagonal(dna);
	}

	boolean hasMutationByRow (String [] dna) {
		for (String i: dna) {
			char c = i.charAt(0), aux;
			int count = 1;
			for (int j=1; j<i.length(); j++) {
				aux = i.charAt(j);
				if (c==aux) {
					count++;
					if (count>3) return true;
				} else {
					c = aux;
					count = 1;
				}
			}
		}

		return false;
	}

	boolean hasMutationByCols (String [] dna) {
		int numberRows = dna.length;
		int numberCols = dna[0].length();
		for (int x=0; x<numberCols; x++) {
			char c = dna[0].charAt(x), aux;
			int count = 1;
			for (int y=1; y<numberRows; y++) {
				aux = dna[y].charAt(x);
				if (c==aux) {
					count++;
					if (count>3) return true;
				} else {
					c = aux;
					count = 1;
				}
			}
		}

		return false;
	}

	boolean hasMutationByDiagonal (String [] dna) {
		String [] secuence = inverseSecuence(dna);

		return hasMutationDiagonal(dna) || hasMutationDiagonal(secuence);
	}

	boolean hasMutationDiagonal (String [] dna) {
		int limitY = dna.length;
		int limitX = dna[0].length();
		for (int i=0; i<limitY; i++) {
			for (int j=0; j<limitX; j++) {
				char c = dna[i].charAt(j), aux;
				int y = i+1;
				int x = j+1;
				int count = 1;
				String chain = "" + c;
				while (y<limitY && x<limitX) {
					aux = dna[y].charAt(x);
					chain = chain + c;
					if (c==aux) {
						count++;
						if (count>3) return true;
					} else {
						c = aux;
						count = 1;
					}
					y++;
					x++;
				}
			}
		}

		return false;
	}

	String [] inverseSecuence (String [] dna) {
		String [] secuence = Arrays.stream(dna).map(row -> lineInverse(row)).toArray(String[]::new);

		return secuence;
	}

	String lineInverse (String line) {
		char [] chars = new char [line.length()];
		for (int p=0,i=line.length()-1; i>=0; i--, p++) chars[p]=line.charAt(i);

		return new String(chars);
	}

}