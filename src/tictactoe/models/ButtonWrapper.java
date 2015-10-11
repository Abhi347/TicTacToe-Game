/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.models;

import javax.swing.JButton;

/**
 *
 * @author abhi
 */
public class ButtonWrapper {
    private JButton mButton;
    private int position = 0;
    private String mText;
    
    public ButtonWrapper(JButton button){
        this.mButton = button;
    }

    public JButton getButton() {
        return mButton;
    }

    public void setButton(JButton button) {
        this.mButton = button;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        this.mText = text;
        this.mButton.setText(text);
    }
}
