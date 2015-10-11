package ticatactoe.managers;

import java.util.ArrayList;
import tictactoe.models.ButtonWrapper;
import tictactoe.models.WinPattern;

public class GameManager {
    //region Singleton

    private static GameManager mInstance;

    public static GameManager getInstance() {
        if (mInstance == null) {
            mInstance = new GameManager();
        }
        return mInstance;
    }

    private GameManager() {
        addPaterns();
    }
    //endregion SingleTon

    private int mCurrentPlayer = 0;
    private String mPlayer1Name;
    private String mPlayer2Name;
    private boolean isStopped = false;

    private WinPattern[] mPatterns = new WinPattern[8];

    public int getCurrentPlayer() {
        return mCurrentPlayer;
    }

    public String getPlayer1Name() {
        return mPlayer1Name;
    }

    public String getPlayer2Name() {
        return mPlayer2Name;
    }

    public int setPlayerName(String playerName) {
        if (mCurrentPlayer == 0) {
            mPlayer1Name = playerName;
            mCurrentPlayer = 1;
            return mCurrentPlayer;
        } else {
            mPlayer2Name = playerName;
            mCurrentPlayer = 0;
            return mCurrentPlayer;
        }
    }

    public void playChance(ArrayList<ButtonWrapper> buttons, int position) {
        if(isStopped){
            System.out.println("Game Stopped! Please Restart!");
            return;
        }
        ButtonWrapper wrapper = buttons.get(position);
        boolean hasWin = false;
        String text = wrapper.getText();
        if (text == null || text.isEmpty()) {
            if (mCurrentPlayer == 0) {
                wrapper.setText("X");
                hasWin = checkWinningCondition(buttons,position);
                if (!hasWin) {
                    mCurrentPlayer = 1;
                }
            } else {
                wrapper.setText("O");
                hasWin = checkWinningCondition(buttons,position);
                if (!hasWin) {
                    mCurrentPlayer = 0;
                }
            }
        }
        wrapper.getButton().setEnabled(false);
        if(hasWin){
            System.out.println("Player no. "+mCurrentPlayer+" has won!");
            isStopped = true;
        }else{
            boolean isEmpty = false;
            for(ButtonWrapper button:buttons){
                if(button.getText()==null || button.getText().isEmpty()){
                    isEmpty = true;
                    break;
                }
            }
            if(!isEmpty){
                System.out.println("DRAW!");
                isStopped = true;
            }
        }
    }

    private void addPaterns() {
        mPatterns[0] = new WinPattern(0, 1, 2);
        mPatterns[1] = new WinPattern(3, 4, 5);
        mPatterns[2] = new WinPattern(6, 7, 8);
        mPatterns[3] = new WinPattern(0, 3, 6);
        mPatterns[4] = new WinPattern(1, 4, 7);
        mPatterns[5] = new WinPattern(2, 5, 8);
        mPatterns[6] = new WinPattern(0, 4, 8);
        mPatterns[7] = new WinPattern(2, 4, 6);
    }

    private boolean checkWinningCondition(ArrayList<ButtonWrapper> buttons, int position) {
        boolean win = false;
        for(WinPattern pattern:mPatterns){
            win = pattern.checkPattern(buttons,position);
            if(win){
                GUIManager.getInstance().paintGreen(pattern, buttons);
                return true;
            }
        }
        return false;
    }

    public void restartGame() {
        mCurrentPlayer = 0;
        isStopped = false;
    }

}
