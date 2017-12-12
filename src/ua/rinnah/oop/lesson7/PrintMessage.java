package ua.rinnah.oop.lesson7;

public class PrintMessage implements Runnable {

   private String str;
   private Action action;
   private int turn;

        public PrintMessage(Action action, String str, int turn) {
            super();
            this.action = action;
            this.str = str;
            this.turn = turn;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++){
                action.printText(str + (i + 1), turn);
            }
        }

}
