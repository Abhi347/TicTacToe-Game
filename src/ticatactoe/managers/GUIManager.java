/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticatactoe.managers;

import java.awt.Color;
import java.util.ArrayList;
import tictactoe.models.ButtonWrapper;
import tictactoe.models.WinPattern;
import tictactoe.swing.GameBoardScreen;
import tictactoe.swing.InputFrame;
import tictactoe.swing.StartScreen;

/**
 *
 * @author abhi
 */
public class GUIManager {
    //region Singleton

    private static GUIManager mInstance;

    public static GUIManager getInstance() {
        if (mInstance == null) {
            mInstance = new GUIManager();
        }
        return mInstance;
    }

    private GUIManager() {
    }
    //endregion SingleTon

    InputFrame mInputFrame;
    StartScreen mStartScreen;
    GameBoardScreen mGameBoard;
    

    public void init() {
        createFrames();
    }

    public void createFrames() {
        mInputFrame = new InputFrame();
        mStartScreen = new StartScreen();
        mGameBoard = new GameBoardScreen();

        mInputFrame.setVisible(true);
    }

    public void onInputSubmit(String playerName) {
        mInputFrame.setError(null);
        int currentPlayer = GameManager.getInstance().setPlayerName(playerName);
        if (currentPlayer == 0) {
            mInputFrame.setVisible(false);
            initStartScreen();            
        } else {
            mInputFrame.changeLabel();
        }
    }

    public void initStartScreen() {
        mStartScreen.setVisible(true);
        String player1Name = GameManager.getInstance().getPlayer1Name();
        String player2Name = GameManager.getInstance().getPlayer2Name();
        mStartScreen.setPlayerNames(player1Name, player2Name);
    }

    public void startGame() {
        mStartScreen.setVisible(false);
        mGameBoard.setVisible(true);
        mGameBoard.updateChance(GameManager.getInstance().getCurrentPlayer(),GameManager.getInstance().getPlayer1Name(),GameManager.getInstance().getPlayer2Name());
    }
    
    public void paintGreen(WinPattern pattern, ArrayList<ButtonWrapper> wrapper){
        for(int position:pattern.getPattern()){
            wrapper.get(position).getButton().setBackground(Color.green);
            wrapper.get(position).getButton().setOpaque(true);
            
        }
    }
}
