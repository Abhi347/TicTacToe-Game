/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.models;

import java.util.ArrayList;

/**
 *
 * @author abhi
 */
public class WinPattern {
    private int [] pattern = new int[3];
    public WinPattern(int i, int j, int k){
        pattern[0] = i;
        pattern[1] = j;
        pattern[2] = k;
    }

    public boolean checkPattern(ArrayList<ButtonWrapper> buttons, int position) {
        String value=null;
        for(int i:pattern){
            String data = buttons.get(i).getText();
            if(data==null || data.isEmpty()){
                return false;
            }
            if(value ==null){
                value = data;
            }else{
                if(!data.equals(value)){
                    return false;
                }
            }
        }
        return true;
    }

    public int[] getPattern() {
        return pattern;
    }
}
