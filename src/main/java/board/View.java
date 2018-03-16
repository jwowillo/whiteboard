package board;

import java.util.ArrayList;
import java.util.List;

/** View is an immutable Board. */
public class View {

  /** board being viewed. */
  private final Board board;

  private final List<Filter> filters;

  public View(Board board) {
    this(board, new ArrayList<>());
  }

  /** View of the Board. */
  public View(Board board, List<Filter> filters) {
    this.board = board;
    this.filters = filters;
  }

  public List<Note> unfilteredNotes(Topic topic) {
    return board.notes(topic);
  }

  /** topics from the View's Board. */
  public List<Topic> topics() {
    return board.topics();
  }

  /** notes from the View's Board. */
  public List<Note> notes(Topic topic) {
    List<Note> notes = new ArrayList<>();
    for (Note note : unfilteredNotes(topic)) {
      boolean shouldInclude = true;
      for (Filter filter : filters) {
        if (!note.content().contains(filter.term())) {
          shouldInclude = false;
        }
      }
      if (!shouldInclude) {
        continue;
      }
      notes.add(note);
    }
    return notes;
  }

  public List<Filter> filters() {
    return new ArrayList<>(filters);
  }

}