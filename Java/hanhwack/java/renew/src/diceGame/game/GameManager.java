package diceGame.game;

import diceGame.player.Player;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    final private int PLAYER_NUM = 5;
    final private List<Player> playerList = new ArrayList<>();
    //final private Player[] playerArray = new Player[PLAYER_NUM];

    public GameManager() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            playerList.add(new Player("플레이어" + (i + 1)));
            //playerArray[i] = new Player("플레이어" + (i + 1));
            System.out.println(playerList.get(i));
            //System.out.println(playerArray[i]);
        }
    }

    /*private int findTargetPlayerIndex (int currentPlayerIndex) {
        // 상대편 찾기 (1:1 상황)
        /*int targetPlayerIndex = 0;

        if (currentPlayerIndex == 0) {
            targetPlayerIndex = 1;
        }

        return targetPlayerIndex;*/

        // 전체공격으로 변경
        // 모든 플레이어를 대상으로 설정


    private List<Integer> findAllTargetPlayerIndex (int currentPlayerIndex) {
        List<Integer> targetPlayerIndexList = new ArrayList<Integer>();
        for (int i = 0; i < playerList.size(); i++) {
            if (i != currentPlayerIndex) {
                targetPlayerIndexList.add(i);
                }
            }
            return targetPlayerIndexList;
        }

    private int findSpecialDiceNumber (int playerIndex) {
        final int ARRAY_BIAS = 1;
        final int SPECIAL_DICE_INDEX = 3 - ARRAY_BIAS;

        Dice currentPlayerSpecialDice =
                playerList.get(playerIndex).getSelectedGameDice(SPECIAL_DICE_INDEX);
                //playerArray[playerIndex].getSelectedGameDice(SPECIAL_DICE_INDEX);

        if (currentPlayerSpecialDice == null) { return 0; }

        int currentPlayerSpecialDiceNumber =
                currentPlayerSpecialDice.getDiceNumber();

        return currentPlayerSpecialDiceNumber;
    }

    public void playGame() {
        final int STEAL = 1;
        final int BUFF = 3;
        final int DEATH = 4;

        final int STEAL_SCORE = 3;
        final int BUFF_SCORE = 2;
        final int DEATH_SCORE = -1;

        for (int i = 0; i < PLAYER_NUM; i++) {
            int currentPlayerSpecialDiceNumber = findSpecialDiceNumber(i);

            if (currentPlayerSpecialDiceNumber == 0) {
                continue; }

            //현재 스틸스코어 1인만가능 이를 전체공격으로 변환 필요
            List<Integer> targetPlayerIndex = findAllTargetPlayerIndex(i);

            GameScore targetPlayerScore =
                    playerList.get(targetPlayerIndex).getGameScore();
                    //playerArray[targetPlayerIndex].getGameScore();

            GameScore currentPlayerScore =
                    playerList.get(i).getGameScore();
                    //playerArray[i].getGameScore();

            switch (currentPlayerSpecialDiceNumber) {
                /*case STEAL:
                    targetPlayerScore.takeScore(currentPlayerScore, STEAL_SCORE);
                    break;*/
                case STEAL:
                    List<Integer> targetPlayerIndexList = findAllTargetPlayerIndex(i);
                    for (int targetPlayerIndex : targetPlayerIndexList) {
                        GameScore targetPlayerScore =
                        playerList.get(targetPlayerIndex).getGameScore();
                        targetPlayerScore.takeScore(currentPlayerScore, STEAL_SCORE);
                    }
                     break;

                case BUFF:
                    currentPlayerScore.addScore(BUFF_SCORE);
                    break;

                case DEATH:
                    currentPlayerScore.loseAll(DEATH_SCORE);
                    break;
            }
        }
    }

    public void printResult() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            System.out.println(playerList.get(i));
            //System.out.println(playerArray[i]);
        }
    }


    public void checkWinner() {
        // TODO: 확장성 문제가 존재함 추후 사용자 숫자 증대시 리팩토링 필요

        GameScore firstPlayerScore = playerList.get(0).getGameScore();
        GameScore secondPlayerScore = playerList.get(1).getGameScore();

        final int firstPlayerScoreTotalScore = firstPlayerScore.getTotalScore();
        final int secondPlayerScoreTotalScore = secondPlayerScore.getTotalScore();

        if (firstPlayerScoreTotalScore > secondPlayerScoreTotalScore) {
            System.out.println("승자: " + playerList.get(0).getName());
            return;
        }
        if (firstPlayerScoreTotalScore < secondPlayerScoreTotalScore) {
            System.out.println("승자: " + playerList.get(1).getName());
            return;
        }
            System.out.println("무승부");
        }


       /* GameScore firstPlayerScore = playerArray[0].getGameScore();
         GameScore secondPlayerScore = playerArray[1].getGameScore();

        final int firstPlayerScoreTotalScore = firstPlayerScore.getTotalScore();
        final int secondPlayerScoreTotalScore = secondPlayerScore.getTotalScore();

        if (firstPlayerScoreTotalScore > secondPlayerScoreTotalScore) {
            System.out.println("승자: " + playerArray[0].getName());
            return;
        }
        if (firstPlayerScoreTotalScore < secondPlayerScoreTotalScore) {
            System.out.println("승자: " + playerArray[1].getName());
            return;
        }
            System.out.println("무승부");
        }*/
}
