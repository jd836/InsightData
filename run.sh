#!/bin/sh

#The input files are under InsightData/wc_input
#The output files are under InsightData/wc_output
#To run solution, cd to the InsightData directory
cd src
javac *.java
java WordCountMain
java RunningMedianMain


