package com.example.robot_cleaning;

public class Robot {

    public static void main(String[] s){
        String[] input = {"...x..","....xx","..x..."};
        //String[] input = {".....x","..x..x","..x..."};

        String currentString = input[0];
        int cleaned = 0;
        int interestedColumn=0;
        int currentRow=0;
        int i =0;
        for(i=0;i<currentString.length();i++){
            if(currentString.charAt(i)=='.'){
                cleaned=cleaned+1;
                interestedColumn=i;
            }
            else if(currentString.charAt(i)=='x' || i==currentString.length()){
                currentRow = currentRow+1;
                if(input[currentRow].charAt(interestedColumn)!='x') {
                    cleaned = moveDownward(currentRow, interestedColumn, cleaned, input);
                }
                break;

            }
        }
        System.out.println("cleaned : "+cleaned);
    }

    private static int moveDownward(int currentRow, int interestedColumn, int cleaned, String[] input) {
        String currentString = input[currentRow];
        if(currentString.charAt(interestedColumn)=='.'){
            cleaned=cleaned+1;
            if(currentRow<input.length-1) {
                currentRow = currentRow + 1;
                cleaned = moveDownward(currentRow, interestedColumn, cleaned, input);
            }
        }
        else if(currentString.charAt(interestedColumn)=='x' || currentRow==input.length-1){
            interestedColumn=interestedColumn-1;
            if(input[currentRow].charAt(interestedColumn)!='x') {
                cleaned = moveLeft(interestedColumn, currentRow, cleaned, input);
            }
        }
        return cleaned;
    }

    private static int moveLeft(int interestedColumn, int currentRow, int cleaned, String[] input) {
        String currentString = input[currentRow];
        if(currentString.charAt(interestedColumn)=='.'){
            cleaned++;
            if(interestedColumn>0 && currentString.charAt(interestedColumn)=='.') {
                interestedColumn = interestedColumn - 1;
                cleaned = moveLeft(interestedColumn, currentRow, cleaned, input);
            }
        }

        else if(currentString.charAt(interestedColumn)=='x' || interestedColumn==0){
            currentRow=currentRow-1;
            if(input[currentRow].charAt(interestedColumn)!='x') {
                moveUp(interestedColumn, currentRow, cleaned, input);
            }
        }

        return cleaned;
    }

    private static int moveUp(int interestedColumn, int currentRow, int cleaned, String[] input) {

        String currentString = input[currentRow];
        if(currentString.charAt(interestedColumn)=='.'){
            cleaned++;
            if(currentRow>0) {
                currentRow=currentRow-1;
                cleaned = moveUp(interestedColumn, currentRow, cleaned, input);
            }
        }

        else if(currentString.charAt(interestedColumn)=='x' || currentRow==0){
            interestedColumn=interestedColumn+1;
            if(input[currentRow].charAt(interestedColumn)!='x')
                cleaned=moveRight(interestedColumn,currentRow,cleaned,input);
        }
        return cleaned;
    }

    private static int moveRight(int interestedaColumn, int currentRow, int cleaned, String[] input) {
        String currentString = input[currentRow];
        if(currentString.charAt(interestedaColumn)=='.'){
            cleaned++;
            if(interestedaColumn<currentString.length()-1) {
                interestedaColumn=interestedaColumn-1;
                cleaned = moveRight(interestedaColumn, currentRow, cleaned, input);
            }
        }

        else if(currentString.charAt(interestedaColumn)=='x' || interestedaColumn>=currentString.length()){
            currentRow=currentRow+1;
            if(input[currentRow].charAt(interestedaColumn)!='x')
                cleaned=moveDownward(interestedaColumn,currentRow,cleaned,input);
        }
        return cleaned;
    }
}
