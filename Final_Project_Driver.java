package SeniorResearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Final_Project_Driver {
	
	public static void main(String args[]) {

	    System.out.println("How do you want the array configured? Input the number of the configuration you want for the testing.");
	    System.out.println("1. Fully randomized");
	    System.out.println("2. Sorted");
	    System.out.println("3. Sorted backwards");
	    System.out.println("4. Every other element is sorted");
	    System.out.println("5. Every element is the same");
	    System.out.println("6. 10% sorted");
	    System.out.println("7. 20% sorted");
	    System.out.println("8. 30% sorted");
	    System.out.println("9. 40% sorted");
	    System.out.println("10. 50% sorted");
	    System.out.println("11. 60% sorted");
	    System.out.println("12. 70% sorted");
	    System.out.println("13. 80% sorted");
	    System.out.println("14. 90% sorted");
	    
	    Scanner input = new Scanner(System.in);
	    int configChoice = input.nextInt();
	    
	    int n = 100000;//Decides how large the arrays fed to the sorts are, minimum value of 100
	    int howMany = 1000;//Decides how many times the sorts are timed whenever the program is run
	    int bucketNumber = n/10;//Decides how many buckets bucket sort uses
	    int nDivided = n/100;
	    
	    //Made a change to quick sort to stop stack overflow in worse case scenario (pivot change)
	    
	    long totalSelectionTime = 0;
	    long totalBubbleTime = 0;
	    long totalInsertionTime = 0;
	    long totalMergeTime = 0;
	    long totalQuickTime = 0;
	    long totalHeapTime = 0;
	    long totalGnomeTime = 0;
	    long totalShellTime = 0;
	    long totalRadixTime = 0;
	    long totalBucketTime = 0;
	    
	    long[] elapsedTimeSelection = new long[howMany];
	    long[] elapsedTimeBubble = new long[howMany];
	    long[] elapsedTimeInsertion = new long[howMany];
	    long[] elapsedTimeMerge = new long[howMany];
	    long[] elapsedTimeQuick = new long[howMany];
	    long[] elapsedTimeHeap = new long[howMany];
	    long[] elapsedTimeGnome = new long[howMany];
	    long[] elapsedTimeShell = new long[howMany];
	    long[] elapsedTimeRadix = new long[howMany];
	    long[] elapsedTimeBucket = new long[howMany];
	    
	    int[] baseArray = new int[n];
	    int[] everyOtherNumberPool = new int[n/2];
	    
	    for (int m = 0; m < howMany; m++) {
	    	
		    switch (configChoice) {
		      case 1://Randomized
		    	  baseArray = createBaseArray(baseArray, n, 0, 0, n);
		    	  break;
		      case 2://Sorted
		    	  for (int i = 0; i < n; i++)
			  	    {
			    		  baseArray[i] = i;
			  	    }
		        break;
		        
		      case 3://Sorted backwards
		    	  int k = n - 1;
		    	  for (int i = 0; i < n; i++)
			  	    {
			    		  baseArray[i] = k;
			    		  k--;
			  	    }
			        break;
			        
		      case 4://Every other element is sorted
		    	  for (int i = 0; i < n; i++)
			  	    {
			    		  baseArray[i] = i;
			    		  i++;
			  	    }
		    	  
		    	  int g = 1;
		    	  for (int i = 0; i < n/2; i++)
			  	    {
		    		  everyOtherNumberPool[i] = g;
		    		  g++;
		    		  g++;
			  	    }
		    	  
		    	  shuffleArray(everyOtherNumberPool);

		    	  g = 0;
		    	  for (int i = 1; i < n; i++)
			  	    {
			    		  baseArray[i] = everyOtherNumberPool[g];
			    		  g++;
			    		  i++;
			  	    }
		    	  
			        break;
		      case 5://Every element in the array is the same
		    	  for (int i = 0; i < nDivided*10; i++)
			  	    {
			    		  baseArray[i] = 0;
			  	    }
			        break;
		      case 6://10% sorted
		    	  for (int i = 0; i < nDivided*10; i++)
			  	    {
			    		  baseArray[i] = i;
			  	    }
		    	  baseArray = createBaseArray(baseArray, n, nDivided*10, nDivided*10, n);
			        break;
			        
		      case 7://20% sorted
		    	  for (int i = 0; i < nDivided*20; i++)
			  	    {
			    		  baseArray[i] = i;
			  	    } 
		    	  baseArray = createBaseArray(baseArray, n, nDivided*20, nDivided*20, n);
			        break;
			        
		      case 8://30% sorted
		    	  for (int i = 0; i < nDivided*30; i++)
			  	    {
			    		  baseArray[i] = i;
			  	    }
		    	  baseArray = createBaseArray(baseArray, n, nDivided*30, nDivided*30, n);
			        break;
			        
		      case 9://40% sorted
		    	  for (int i = 0; i < nDivided*40; i++)
			  	    {
			    		  baseArray[i] = i;
			  	    } 
		    	  baseArray = createBaseArray(baseArray, n, nDivided*40, nDivided*40, n);
			        break;
			        
		      case 10://50% sorted
		    	  for (int i = 0; i < nDivided*50; i++)
			  	    {
			    		  baseArray[i] = i;
			  	    }
		    	  baseArray = createBaseArray(baseArray, n, nDivided*50, nDivided*50, n);
			        break;
			        
		      case 11://60% sorted
		    	  for (int i = 0; i < nDivided*60; i++)
			  	    {
			    		  baseArray[i] = i;
			  	    } 
		    	  baseArray = createBaseArray(baseArray, n, nDivided*60, nDivided*60, n);
			        break;
			        
		      case 12://70% sorted
		    	  for (int i = 0; i < nDivided*70; i++)
			  	    {
			    		  baseArray[i] = i;
			  	    } 
		    	  baseArray = createBaseArray(baseArray, n, nDivided*70, nDivided*70, n);
			        break;
			        
		      case 13://80% sorted
		    	  for (int i = 0; i < nDivided*80; i++)
			  	    {
			    		  baseArray[i] = i;
			  	    } 
		    	  baseArray = createBaseArray(baseArray, n, nDivided*80, nDivided*80, n);
			        break;
			        
		      case 14://90% sorted
		    	  for (int i = 0; i < nDivided*90; i++)
			  	    {
			    		  baseArray[i] = i;
			  	    } 
		    	  baseArray = createBaseArray(baseArray, n, nDivided*90, nDivided*90, n);
			        break;
		      default:
		    	  System.out.println("Error, the given input was not one of the choices.");
		    	  }
		    
		    
		    int[] selectionArray = new int[n];
		    int[] bubbleArray = new int[n];
		    int[] insertionArray = new int[n];
		    int[] mergeArray = new int[n];
		    int[] quickArray = new int[n];
		    int[] heapArray = new int[n];
		    int[] gnomeArray = new int[n];
		    int[] shellArray = new int[n];
		    int[] radixArray = new int[n];
		    int[] bucketArray = new int[n];
		
		    for (int i = 0; i < n; i++) {
		    	selectionArray[i] = baseArray[i];
		    	bubbleArray[i] = baseArray[i];
		    	insertionArray[i] = baseArray[i];
		    	mergeArray[i] = baseArray[i];
		    	quickArray[i] = baseArray[i];
		    	heapArray[i] = baseArray[i];
		    	gnomeArray[i] = baseArray[i];
		    	shellArray[i] = baseArray[i];
		    	radixArray[i] = baseArray[i];
		    	bucketArray[i] = baseArray[i];
		    }
		    
		    long startTime;
		    long currentTime;
		    
	    	startTime = System.currentTimeMillis();
	    	bucketSort(bucketArray);
	    	currentTime = System.currentTimeMillis();
	    	elapsedTimeBucket[m] = (long) ((currentTime - startTime));
	    	totalBucketTime = totalBucketTime + elapsedTimeBucket[m];
	    	System.out.println("Bucket Sort " + (m + 1) + " is finished.");
	    	
	    	startTime = System.currentTimeMillis();
	    	radixSort(radixArray, n);
	    	currentTime = System.currentTimeMillis();
	    	elapsedTimeRadix[m] = (long) ((currentTime - startTime));
	    	totalRadixTime = totalRadixTime + elapsedTimeRadix[m];
	    	System.out.println("Radix Sort " + (m + 1) + " is finished.");
	    
	    	startTime = System.currentTimeMillis();
	    	shellSort(shellArray);
	    	currentTime = System.currentTimeMillis();
	    	elapsedTimeShell[m] = (long) ((currentTime - startTime));
	    	totalShellTime = totalShellTime + elapsedTimeShell[m];
	    	System.out.println("Shell Sort " + (m + 1) + " is finished.");
	    	
	    	startTime = System.currentTimeMillis();
	    	gnomeSort(gnomeArray, n);
	    	currentTime = System.currentTimeMillis();
	    	elapsedTimeGnome[m] = (long) ((currentTime - startTime));
	    	totalGnomeTime = totalGnomeTime + elapsedTimeGnome[m];
	    	System.out.println("Gnome Sort " + (m + 1) + " is finished.");
	    
	    	startTime = System.currentTimeMillis();
	    	heapSort(heapArray);
	    	currentTime = System.currentTimeMillis();
	    	elapsedTimeHeap[m] = (long) ((currentTime - startTime));
	    	totalHeapTime = totalHeapTime + elapsedTimeHeap[m];
	    	System.out.println("Heap Sort " + (m + 1) + " is finished.");
	    
	    	startTime = System.currentTimeMillis();
	    	quickSort(quickArray, 0, n-1);
	    	currentTime = System.currentTimeMillis();
	    	elapsedTimeQuick[m] = (long) ((currentTime - startTime));
	    	totalQuickTime = totalQuickTime + elapsedTimeQuick[m];
	    	System.out.println("Quick Sort " + (m + 1) + " is finished.");
	    
	    	startTime = System.currentTimeMillis();
	    	mergeSort(mergeArray, 0, n - 1);
	    	currentTime = System.currentTimeMillis();
	    	elapsedTimeMerge[m] = (long) ((currentTime - startTime));
	    	totalMergeTime = totalMergeTime + elapsedTimeMerge[m];
	    	System.out.println("Merge Sort " + (m + 1) + " is finished.");
	    
	    	startTime = System.currentTimeMillis();
	    	insertionSort(insertionArray);
	    	currentTime = System.currentTimeMillis();
	    	elapsedTimeInsertion[m] = (long) ((currentTime - startTime));
	    	totalInsertionTime = totalInsertionTime + elapsedTimeInsertion[m];
	    	System.out.println("Insertion Sort " + (m + 1) + " is finished.");
	    
	    	startTime = System.currentTimeMillis();
	    	bubbleSort(bubbleArray);
	    	currentTime = System.currentTimeMillis();
	    	elapsedTimeBubble[m] = (long) ((currentTime - startTime));
	    	totalBubbleTime = totalBubbleTime + elapsedTimeBubble[m];
	    	System.out.println("Bubble Sort " + (m + 1) + " is finished.");
	    
	    	startTime = System.currentTimeMillis();
	    	selectionSort(selectionArray);
	    	currentTime = System.currentTimeMillis();
	    	elapsedTimeSelection[m] = (long) ((currentTime - startTime));
	    	totalSelectionTime = totalSelectionTime + elapsedTimeSelection[m];
	    	System.out.println("Selection Sort " + (m + 1) + " is finished.");
	    }
	    

	    
	    Long averageElapsedBucket = totalBucketTime/howMany;
	    Long averageElapsedRadix = totalRadixTime/howMany;
	    Long averageElapsedShell = totalShellTime/howMany;
	    Long averageElapsedGnome = totalGnomeTime/howMany;
	    Long averageElapsedHeap = totalHeapTime/howMany;
	    Long averageElapsedQuick = totalQuickTime/howMany;
	    Long averageElapsedMerge = totalMergeTime/howMany;
	    Long averageElapsedInsertion = totalInsertionTime/howMany;
	    Long averageElapsedBubble = totalBubbleTime/howMany;
	    Long averageElapsedSelection = totalSelectionTime/howMany;
	    
	    
	    Long selectionStandardTotal = (long) 0;
	    Long bubbleStandardTotal = (long) 0;
	    Long insertionStandardTotal = (long) 0;
	    Long mergeStandardTotal = (long) 0;
	    Long quickStandardTotal = (long) 0;
	    Long heapStandardTotal = (long) 0;
	    Long gnomeStandardTotal = (long) 0;
	    Long shellStandardTotal = (long) 0;
	    Long radixStandardTotal = (long) 0;
	    Long bucketStandardTotal = (long) 0;
	    
	    Long selectionStandardAverage = (long) 0;
	    Long bubbleStandardAverage = (long) 0;
	    Long insertionStandardAverage = (long) 0;
	    Long mergeStandardAverage = (long) 0;
	    Long quickStandardAverage = (long) 0;
	    Long heapStandardAverage = (long) 0;
	    Long gnomeStandardAverage = (long) 0;
	    Long shellStandardAverage = (long) 0;
	    Long radixStandardAverage = (long) 0;
	    Long bucketStandardAverage = (long) 0;

	    //Bucket Standard Deviation
	    Long averageBucketTime = totalBucketTime/howMany;
	    for (int m = 0; m < howMany; m++) {
	    	bucketStandardTotal = bucketStandardTotal + Math.abs((elapsedTimeBucket[m] - averageElapsedBucket)^2);
	    }
	    //bucketStandardAverage = bucketStandardTotal/howMany;
	    
	    //Radix Standard Deviation
	    Long averageRadixTime = totalRadixTime/howMany;
	    for (int m = 0; m < howMany; m++) {
	    	radixStandardTotal = radixStandardTotal + Math.abs((elapsedTimeRadix[m] - averageElapsedRadix)^2);
	    }
	    //radixStandardAverage = radixStandardTotal/howMany;
	    
	    //Shell Standard Deviation
	    Long averageShellTime = totalShellTime/howMany;
	    for (int m = 0; m < howMany; m++) {
	    	shellStandardTotal = shellStandardTotal + Math.abs((elapsedTimeShell[m] - averageElapsedShell)^2);
	    }
	    //shellStandardAverage = shellStandardTotal/howMany;
	    
	    //Gnome Standard Deviation
	    Long averageGnomeTime = totalGnomeTime/howMany;
	    for (int m = 0; m < howMany; m++) {
	    	gnomeStandardTotal = gnomeStandardTotal + Math.abs((elapsedTimeGnome[m] - averageElapsedGnome)^2);
	    }
	    //gnomeStandardAverage = gnomeStandardTotal/howMany;
	    
	    //Heap Standard Deviation
	    Long averageHeapTime = totalHeapTime/howMany;
	    for (int m = 0; m < howMany; m++) {
	    	heapStandardTotal = heapStandardTotal + Math.abs((elapsedTimeHeap[m] - averageElapsedHeap)^2);
	    }
	    //heapStandardAverage = heapStandardTotal/howMany;
	    
	    //Quick Standard Deviation
	    Long averageQuickTime = totalQuickTime/howMany;
	    for (int m = 0; m < howMany; m++) {
	    	quickStandardTotal = quickStandardTotal + Math.abs((elapsedTimeQuick[m] - averageElapsedQuick)^2);
	    }
	    //quickStandardAverage = quickStandardTotal/howMany;
	    
	    //Merge Standard Deviation
	    Long averageMergeTime = totalMergeTime/howMany;
	    for (int m = 0; m < howMany; m++) {
	    	mergeStandardTotal = mergeStandardTotal + Math.abs((elapsedTimeMerge[m] - averageElapsedMerge)^2);
	    }
	    //mergeStandardAverage = mergeStandardTotal/howMany;
	    
	    //Insertion Standard Deviation
	    Long averageInsertionTime = totalInsertionTime/howMany;
	    for (int m = 0; m < howMany; m++) {
	    	insertionStandardTotal = insertionStandardTotal + Math.abs((elapsedTimeInsertion[m] - averageElapsedInsertion)^2);
	    }
	    //insertionStandardAverage = insertionStandardTotal/howMany;
	    
	    //Bubble Standard Deviation
	    Long averageBubbleTime = totalBubbleTime/howMany;
	    for (int m = 0; m < howMany; m++) {
	    	bubbleStandardTotal = bubbleStandardTotal + Math.abs((elapsedTimeBubble[m] - averageElapsedBubble)^2);
	    }
	    //bubbleStandardAverage = bubbleStandardTotal/howMany;
	    
	    //Selection Standard Deviation
	    Long averageSelectionTime = totalSelectionTime/howMany;
	    for (int m = 0; m < howMany; m++) {
	    	selectionStandardTotal = selectionStandardTotal + Math.abs((elapsedTimeSelection[m] - averageElapsedSelection)^2);
	    }
	    //selectionStandardAverage = selectionStandardTotal/howMany;
	    
	    
	    //Bucket high and low storage
	    Long bucketHighest = (long) 0;
	    Long bucketLowest = (long) 999999999;
	    
	    //Radix high and low storage
	    Long radixHighest = (long) 0;
	    Long radixLowest = (long) 999999999;
	    
	    //Shell high and low storage
	    Long shellHighest = (long) 0;
	    Long shellLowest = (long) 999999999;
	    
	    //Gnome high and low storage
	    Long gnomeHighest = (long) 0;
	    Long gnomeLowest = (long) 999999999;
	    
	    //Heap high and low storage
	    Long heapHighest = (long) 0;
	    Long heapLowest = (long) 999999999;
	    
	    //Bucket high and low storage
	    Long quickHighest = (long) 0;
	    Long quickLowest = (long) 999999999;
	    
	    //Bucket high and low storage
	    Long mergeHighest = (long) 0;
	    Long mergeLowest = (long) 999999999;
	    
	    //Bucket high and low storage
	    Long insertionHighest = (long) 0;
	    Long insertionLowest = (long) 999999999;
	    
	    //Bucket high and low storage
	    Long bubbleHighest = (long) 0;
	    Long bubbleLowest = (long) 999999999;
	    
	    //Bucket high and low storage
	    Long selectionHighest = (long) 0;
	    Long selectionLowest = (long) 999999999;
	    
	    for (int f = 0; f < howMany; f++) {
	    	
	    	//Bucket high and low check
	    	if (elapsedTimeBucket[f] > bucketHighest) {
	    		bucketHighest = elapsedTimeBucket[f];
	    	}
	    	if (elapsedTimeBucket[f] < bucketLowest) {
	    		bucketLowest = elapsedTimeBucket[f];
	    	}
	    	
	    	//Radix high and low check
	    	if (elapsedTimeRadix[f] > radixHighest) {
	    		radixHighest = elapsedTimeRadix[f];
	    	}
	    	if (elapsedTimeRadix[f] < radixLowest) {
	    		radixLowest = elapsedTimeRadix[f];
	    	}
	    	
	    	//Shell high and low check
	    	if (elapsedTimeShell[f] > shellHighest) {
	    		shellHighest = elapsedTimeShell[f];
	    	}
	    	if (elapsedTimeShell[f] < shellLowest) {
	    		shellLowest = elapsedTimeShell[f];
	    	}
	    	
	    	//Gnome high and low check
	    	if (elapsedTimeGnome[f] > gnomeHighest) {
	    		gnomeHighest = elapsedTimeGnome[f];
	    	}
	    	if (elapsedTimeGnome[f] < gnomeLowest) {
	    		gnomeLowest = elapsedTimeGnome[f];
	    	}
	    	
	    	//Heap high and low check
	    	if (elapsedTimeHeap[f] > heapHighest) {
	    		heapHighest = elapsedTimeHeap[f];
	    	}
	    	if (elapsedTimeHeap[f] < heapLowest) {
	    		heapLowest = elapsedTimeHeap[f];
	    	}
	    	
	    	//Quick high and low check
	    	if (elapsedTimeQuick[f] > quickHighest) {
	    		quickHighest = elapsedTimeQuick[f];
	    	}
	    	if (elapsedTimeQuick[f] < quickLowest) {
	    		quickLowest = elapsedTimeQuick[f];
	    	}
	    	
	    	//Merge high and low check
	    	if (elapsedTimeMerge[f] > mergeHighest) {
	    		mergeHighest = elapsedTimeMerge[f];
	    	}
	    	if (elapsedTimeMerge[f] < mergeLowest) {
	    		mergeLowest = elapsedTimeMerge[f];
	    	}
	    	
	    	//Insertion high and low check
	    	if (elapsedTimeInsertion[f] > insertionHighest) {
	    		insertionHighest = elapsedTimeInsertion[f];
	    	}
	    	if (elapsedTimeInsertion[f] < insertionLowest) {
	    		insertionLowest = elapsedTimeInsertion[f];
	    	}
	    	
	    	//Bubble high and low check
	    	if (elapsedTimeBubble[f] > bubbleHighest) {
	    		bubbleHighest = elapsedTimeBubble[f];
	    	}
	    	if (elapsedTimeBubble[f] < bubbleLowest) {
	    		bubbleLowest = elapsedTimeBubble[f];
	    	}
	    	
	    	//Selection high and low check
	    	if (elapsedTimeSelection[f] > selectionHighest) {
	    		selectionHighest = elapsedTimeSelection[f];
	    	}
	    	if (elapsedTimeSelection[f] < selectionLowest) {
	    		selectionLowest = elapsedTimeSelection[f];
	    	}
	    }
	    

	    System.out.println("");
	    
	    System.out.println("In a set of " + howMany + " tests, bucket sort took an average of " + averageElapsedBucket + " milliseconds to sort the array with a standard deviation of " + bucketStandardTotal + " milliseconds before finishing calculations.");
	    System.out.println("The fastest time recorded for bucket sort is " + bucketLowest + " milliseconds and the slowest is " + bucketHighest + " milliseconds.");
	    System.out.println("");
	    
	    System.out.println("In a set of " + howMany + " tests, radix sort took an average of " + averageElapsedRadix + " milliseconds to sort the array with a standard deviation of " + radixStandardTotal + " milliseconds before finishing calculations.");
	    System.out.println("The fastest time recorded for radix sort is " + radixLowest + " milliseconds and the slowest is " + radixHighest + " milliseconds.");
	    System.out.println("");
	    
	    System.out.println("In a set of " + howMany + " tests, shell sort took an average of " + averageElapsedShell + " milliseconds to sort the array with a standard deviation of " + shellStandardTotal + " milliseconds before finishing calculations.");
	    System.out.println("The fastest time recorded for shell sort is " + shellLowest + " milliseconds and the slowest is " + shellHighest + " milliseconds.");
	    System.out.println("");
	    
	    System.out.println("In a set of " + howMany + " tests, gnome sort took an average of " + averageElapsedGnome + " milliseconds to sort the array with a standard deviation of " + gnomeStandardTotal + " milliseconds before finishing calculations.");
	    System.out.println("The fastest time recorded for gnome sort is " + gnomeLowest + " milliseconds and the slowest is " + gnomeHighest + " milliseconds.");
	    System.out.println("");
	    
	    System.out.println("In a set of " + howMany + " tests, heap sort took an average of " + averageElapsedHeap + " milliseconds to sort the array with a standard deviation of " + heapStandardTotal + " milliseconds before finishing calculations.");
	    System.out.println("The fastest time recorded for heap sort is " + heapLowest + " milliseconds and the slowest is " + heapHighest + " milliseconds.");
	    System.out.println("");
	    
	    System.out.println("In a set of " + howMany + " tests, quick sort took an average of " + averageElapsedQuick + " milliseconds to sort the array with a standard deviation of " + quickStandardTotal + " milliseconds before finishing calculations.");
	    System.out.println("The fastest time recorded for quick sort is " + quickLowest + " milliseconds and the slowest is " + quickHighest + " milliseconds.");
	    System.out.println("");
	    
	    System.out.println("In a set of " + howMany + " tests, merge sort took an average of " + averageElapsedMerge + " milliseconds to sort the array with a standard deviation of " + mergeStandardTotal + " milliseconds before finishing calculations.");
	    System.out.println("The fastest time recorded for merge sort is " + mergeLowest + " milliseconds and the slowest is " + mergeHighest + " milliseconds.");
	    System.out.println("");
	    
	    System.out.println("In a set of " + howMany + " tests, insertion sort took an average of " + averageElapsedInsertion + " milliseconds to sort the array with a standard deviation of " + insertionStandardTotal + " milliseconds before finishing calculations.");
	    System.out.println("The fastest time recorded for insertion sort is " + insertionLowest + " milliseconds and the slowest is " + insertionHighest + " milliseconds.");
	    System.out.println("");
	    
	    System.out.println("In a set of " + howMany + " tests, bubble sort took an average of " + averageElapsedBubble + " milliseconds to sort the array with a standard deviation of " + bubbleStandardTotal + " milliseconds.");
	    System.out.println("The fastest time recorded for bubble sort is " + bubbleLowest + " milliseconds and the slowest is " + bubbleHighest + " milliseconds.");
	    System.out.println("");
	    
	    System.out.println("In a set of " + howMany + " tests, selection sort took an average of " + averageElapsedSelection + " milliseconds to sort the array with a standard deviation of " + selectionStandardTotal + " milliseconds before finishing calculations.");
	    System.out.println("The fastest time recorded for selection sort is " + selectionLowest + " milliseconds and the slowest is " + selectionHighest + " milliseconds.");
	}

/******************************************************************************************************************************************************************************************************************/
	
	//Random number generator
	static int[] createBaseArray(int[] array, int upperBound, int LowerBound, int start, int end) {
		Random rnd = ThreadLocalRandom.current();
		
		for (int i = start; i < end; i++)
	    {
	      array[i] = rnd.nextInt(upperBound - LowerBound) + LowerBound;
	    }
		return array;
	}
	
	static void shuffleArray(int[] ar) {
		    
		    Random rnd = ThreadLocalRandom.current();
		    for (int i = ar.length - 1; i > 0; i--)
		    {
		      int index = rnd.nextInt(i + 1);
		      
		      int a = ar[index];
		      ar[index] = ar[i];
		      ar[i] = a;
		    }
		  }
	
/******************************************************************************************************************************************************************************************************************/
	
	//Bucket Sort
	public static void bucketSort(int[] input) {
	    // get hash codes
	    int[] code = hash(input);
	    
	    // create and initialize buckets to ArrayList: O(n)
	    List<Integer>[] buckets = new List[code[1]];
	    for (int i = 0; i < code[1]; i++) {
	      buckets[i] = new ArrayList();
	    }
	    
	    // distribute data into buckets: O(n)
	    for (int i : input) {
	    	
	      //System.out.println("Index is equal to " + hash(i, code));
	      //The issue is here.++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	      buckets[hash(i, code)].add(i);
	    }
	    
	    // sort each bucket O(n)
	    for (List bucket : buckets) {
	      Collections.sort(bucket);
	    }
	    
	    int ndx = 0;
	    // merge the buckets: O(n)
	    for (int b = 0; b < buckets.length; b++) {
	      for (int v : buckets[b]) {
	        input[ndx++] = v;
	      }
	    }
	  }

	  private static int[] hash(int[] input) {
	    int m = input[0];
	    for (int i = 1; i < input.length; i++) {
	      if (m < input[i]) {
	        m = input[i];
	      }
	    }
	    return new int[] { m, (int) Math.sqrt(input.length) };
	  }

	  private static int hash(int i, int[] code) {
	    return (int) ((double) i / code[0] * (code[1] - 1));
	  }

	//Radix Sort 
    static int getMax(int arr[], int n) 
    { 
        int mx = arr[0]; 
        for (int i = 1; i < n; i++) 
            if (arr[i] > mx) 
                mx = arr[i]; 
        return mx; 
    }  
    static void countSort(int arr[], int n, int exp) 
    { 
        int output[] = new int[n]; // output array 
        int i; 
        int count[] = new int[10]; 
        Arrays.fill(count, 0); 
  
        // Store count of occurrences in count[] 
        for (i = 0; i < n; i++) 
            count[(arr[i] / exp) % 10]++; 
  
        // Change count[i] so that count[i] now contains 
        // actual position of this digit in output[] 
        for (i = 1; i < 10; i++) 
            count[i] += count[i - 1]; 
  
        // Build the output array 
        for (i = n - 1; i >= 0; i--) { 
            output[count[(arr[i] / exp) % 10] - 1] = arr[i]; 
            count[(arr[i] / exp) % 10]--; 
        } 
  
        // Copy the output array to arr[], so that arr[] now 
        // contains sorted numbers according to curent digit 
        for (i = 0; i < n; i++) 
            arr[i] = output[i]; 
    } 
    static void radixSort(int arr[], int n) 
    { 
        // Find the maximum number to know number of digits 
        int m = getMax(arr, n); 
  
        // Do counting sort for every digit. Note that 
        // instead of passing digit number, exp is passed. 
        // exp is 10^i where i is current digit number 
        for (int exp = 1; m / exp > 0; exp *= 10) 
            countSort(arr, n, exp); 
    } 
	
	static ///Shell Sort
    int shellSort(int arr[]) 
    { 
        int n = arr.length; 
  
        // Start with a big gap, then reduce the gap 
        for (int gap = n/2; gap > 0; gap /= 2) 
        { 
            // Do a gapped insertion sort for this gap size. 
            // The first gap elements a[0..gap-1] are already 
            // in gapped order keep adding one more element 
            // until the entire array is gap sorted 
            for (int i = gap; i < n; i += 1) 
            { 
                // add a[i] to the elements that have been gap 
                // sorted save a[i] in temp and make a hole at 
                // position i 
                int temp = arr[i]; 
  
                // shift earlier gap-sorted elements up until 
                // the correct location for a[i] is found 
                int j; 
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) 
                    arr[j] = arr[j - gap]; 
  
                // put temp (the original a[i]) in its correct 
                // location 
                arr[j] = temp; 
            } 
        } 
        return 0; 
    } 
	
	//Gnome Sort
	public static void gnomeSort(int arr[], int n) 
    { 
        int index = 0; 
  
        while (index < n) { 
            if (index == 0) 
                index++; 
            if (arr[index] >= arr[index - 1]) 
                index++; 
            else { 
                int temp = 0; 
                temp = arr[index]; 
                arr[index] = arr[index - 1]; 
                arr[index - 1] = temp; 
                index--; 
            } 
        } 
        return; 
    }  
	
	//Heap Sort
	public static void heapSort(int arr[]) 
    { 
        int n = arr.length; 
  
        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(arr, n, i); 
  
        // One by one extract an element from heap 
        for (int i=n-1; i>0; i--) 
        { 
            // Move current root to end 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
  
            // call max heapify on the reduced heap 
            heapify(arr, i, 0); 
        } 
    } 
    // To heapify a subtree rooted with node i which is 
    // an index in arr[]. n is size of heap 
    static void heapify(int arr[], int n, int i) 
    { 
        int largest = i; // Initialize largest as root 
        int l = 2*i + 1; // left = 2*i + 1 
        int r = 2*i + 2; // right = 2*i + 2 
  
        // If left child is larger than root 
        if (l < n && arr[l] > arr[largest]) 
            largest = l; 
  
        // If right child is larger than largest so far 
        if (r < n && arr[r] > arr[largest]) 
            largest = r; 
  
        // If largest is not root 
        if (largest != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
  
            // Recursively heapify the affected sub-tree 
            heapify(arr, n, largest); 
        } 
    }  
	
	//Quick Sort
	static int partition(int arr[], int low, int high) { 
	   int pivot = arr[(high + low)/2];  
	   int i = (low-1); // index of smaller element 
	   for (int j=low; j<high; j++) { 
	      // If current element is smaller than the pivot 
	      if (arr[j] < pivot) { 
	          i++; 
	  
	          // swap arr[i] and arr[j] 
	          int temp = arr[i]; 
	          arr[i] = arr[j]; 
	          arr[j] = temp; 
	       } 
	    } 
	  
	        // swap arr[i+1] and arr[high] (or pivot) 
	        int temp = arr[i+1]; 
	        arr[i+1] = arr[high]; 
	        arr[high] = temp; 
	  
	        return i+1; 
	    } 
	  static void quickSort(int arr[], int low, int high) { 
	     if (low < high) 
	        { 
	            /* pi is partitioning index, arr[pi] is  
	              now at right place */
	            int pi = partition(arr, low, high); 
	  
	            // Recursively sort elements before 
	            // partition and after partition 
	            quickSort(arr, low, pi-1); 
	            quickSort(arr, pi+1, high); 
	        } 
	    }
	
	//Merge Sort
	static void merge(int arr[], int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        int L[] = new int[n1]; 
        int R[] = new int[n2]; 
  
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j = 0; j < n2; ++j) 
            R[j] = arr[m + 1 + j]; 
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) { 
            if (L[i] <= R[j]) { 
                arr[k] = L[i]; 
                i++; 
            } 
            else { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
    static void mergeSort(int arr[], int l, int r) 
    { 
        if (l < r) { 
            // Find the middle point 
            int m = (l + r) / 2; 
  
            // Sort first and second halves 
            mergeSort(arr, l, m); 
            mergeSort(arr, m + 1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
    } 
	
	//Insertion Sort
	static void insertionSort(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        } 
    } 
	
	//Bubble Sort
	static void bubbleSort(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (arr[j] > arr[j+1]) 
                { 
                    // swap arr[j+1] and arr[j] 
                    int temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                } 
    } 
	
	//Selection sort
	static void selectionSort(int arr[]) 
    { 
        int n = arr.length; 
  
        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < n-1; i++) 
        { 
            // Find the minimum element in unsorted array 
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (arr[j] < arr[min_idx]) 
                    min_idx = j; 
  
            // Swap the found minimum element with the first 
            // element 
            int temp = arr[min_idx]; 
            arr[min_idx] = arr[i]; 
            arr[i] = temp; 
        } 
    }  
}
