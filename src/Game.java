class Game {
    Game(){
        init();
    }

    private void init() {
        GameConfigPanel configPanel = new GameConfigPanel();
        GameBoardProcessor gameBoardProcessor = new GameBoardProcessor(configPanel);
        gameBoardProcessor.loadBoard();
    }
}
