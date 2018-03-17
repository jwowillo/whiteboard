package board.cli;

import board.app.App;
import board.app.Displayer;
import board.app.Prompter;
import board.app.StoreSupplier;
import board.observer.Handler;
import board.store.DbStore;

/** Main runs the CLI. */
public class Main {

  /** main runs the CLI. */
  public static void main(String[] args) {
    Prompter prompter = new CliPrompter();
    Displayer displayer = new CliDisplayer();
    Handler handler = new StderrHandler();
    StoreSupplier supplier = () -> new DbStore("board.db");
    new App(prompter, displayer, handler, supplier).run();
  }

}

