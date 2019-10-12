public class BirthdayBookTester {
  public static void main(String[] args) {
    System.out.println("(01)----------------------------------------");
    /* Create a birthday instance with month and day. */
    Birthday bd01 = new Birthday(1, 11);
    System.out.println("(" + bd01.getMonth() + ", " + bd01.getDay() + ")");

    System.out.println("(02)----------------------------------------");
    Birthday bd02 = new Birthday(2, 12);
    Birthday bd03 = new Birthday(3, 13);
    Birthday bd04 = new Birthday(4, 14);
    Birthday bd05 = new Birthday(5, 15);
    Birthday bd06 = new Birthday(6, 16);
    Birthday bd07 = new Birthday(7, 17);
    Birthday bd08 = new Birthday(8, 18);
    Birthday bd09 = new Birthday(9, 19);
    Birthday bd10 = new Birthday(10, 20);
    Birthday bd11 = new Birthday(11, 21);
    Birthday bd12 = new Birthday(12, 22);
    System.out.println(bd01.toString());
    System.out.println(bd02.toString());
    System.out.println(bd03.toString());
    System.out.println(bd04.toString());
    System.out.println(bd05.toString());
    System.out.println(bd06.toString());
    System.out.println(bd07.toString());
    System.out.println(bd08.toString());
    System.out.println(bd09.toString());
    System.out.println(bd10.toString());
    System.out.println(bd11.toString());
    System.out.println(bd12.toString());

    System.out.println("(03)----------------------------------------");
    Birthday bd13 = new Birthday(6, 16);
    System.out.println("bd06: " + bd06.toString());
    System.out.println("bd07: " + bd07.toString());
    System.out.println("bd13: " + bd13.toString());
    System.out.println("Contents of bd06 and bd13 are equal: " + bd06.equals(bd13));
    System.out.println("Contents of bd07 and bd13 are equal: " + bd07.equals(bd13));

    System.out.println("(04)----------------------------------------");
    /* Create a new entry using a name and a birthday. */
    Entry e1 = new Entry("A", bd01);
    System.out.println("Entry e1's name: " + e1.getName());
    System.out.println("Entry e1's birthday: " + e1.getBirthday().toString());
    System.out.println("Entry e1's string value: " + e1.toString());

    System.out.println("(05)----------------------------------------");
    /* Create a new entry using a name, a birth month, and a birth day. */
    Entry e2 = new Entry("B", 2, 12);
    System.out.println("Entry e2's name: " + e2.getName());
    System.out.println("Entry e2's birthday: " + e2.getBirthday().toString());
    System.out.println("Entry e2's string value: " + e2.toString());

    System.out.println("(06)----------------------------------------");
    Entry e3 = new Entry("A", 1, 11);
    System.out.println("e1: " + e1.toString());
    System.out.println("e2: " + e2.toString());
    System.out.println("e3: " + e3.toString());
    System.out.println("Entries e1 and e2 are equal: " + e1.equals(e2));
    System.out.println("Entries e1 and e3 are equal: " + e1.equals(e3));

    System.out.println("(07)----------------------------------------");
    e2.setName("A");
    /* Change e2's birthday to January 11. */
    e2.setBirthday(1, 11);
    System.out.println("e1: " + e1.toString());
    System.out.println("e2: " + e2.toString());
    System.out.println("e3: " + e3.toString());
    System.out.println("Entries e1 and e2 are equal: " + e1.equals(e2));
    System.out.println("Entries e1 and e3 are equal: " + e1.equals(e3));

    System.out.println("(08)----------------------------------------");
    /* Change e3's birthday to the same as bd03. */
    e3.setBirthday(bd03);
    System.out.println("e1: " + e1.toString());
    System.out.println("e2: " + e2.toString());
    System.out.println("e3: " + e3.toString());
    System.out.println("Entries e1 and e2 are equal: " + e1.equals(e2));
    System.out.println("Entries e1 and e3 are equal: " + e1.equals(e3));

    System.out.println("(09)----------------------------------------");
    BirthdayBook bb = new BirthdayBook();
    System.out.println("Number of entries: " + bb.getNumberOfEntries());
    System.out.println("Returned number of entries: " + bb.getEntries().length);

    System.out.println("(10)----------------------------------------");
    System.out.println(bb.toString());

    System.out.println("(11)----------------------------------------");
    System.out.println("Name A exists in book: " + bb.nameExists("A"));
    System.out.println("Name B exists in book: " + bb.nameExists("B"));
    System.out.println("Name C exists in book: " + bb.nameExists("C"));

    System.out.println("(12)----------------------------------------");
    Birthday bdOfA = bb.getBirthday("A");
    Birthday bdOfB = bb.getBirthday("B");
    Birthday bdOfC = bb.getBirthday("C");
    /* Return birthdays on names.
     * When names are non-existing, their associated birthdays are nulls.
     */
    System.out.println("Birthday of A: " + bdOfA); 
    System.out.println("Birthday of B: " + bdOfB);
    System.out.println("Birthday of C: " + bdOfC);

    System.out.println("(13)----------------------------------------");
    /* Get reminders on birthdays.
     * When birthdays are non-existing, no persons will be reminded. */
    String[] toRemind = bb.getReminders(bd13);
    System.out.println("Number of reminders of bd13 (from empty book): " + toRemind.length);
    toRemind = bb.getReminders(6, 16);
    System.out.println("Number of reminders of June 16 (from empty book): " + toRemind.length);

    System.out.println("(14)----------------------------------------");
    /* Remove entries from the book.
     * When names are non-existing name, removing their associated entries have no effect. 
     */
    bb.removeEntry("A"); 
    bb.removeEntry("B");
    bb.removeEntry("C");
    bb.removeEntry("D");
    System.out.println("Number of entries: " + bb.getNumberOfEntries());
    System.out.println("Returned number of entries: " + bb.getEntries().length);

    System.out.println("(15)----------------------------------------");
    /* Add new entries to the book.
     * When names are non-existing, new entries are added to the book. 
     */
    bb.addEntry(e1.getName(), e1.getBirthday().getMonth(), e1.getBirthday().getDay());
    bb.addEntry("B", bd13);
    bb.addEntry("C", 6, 16);
    System.out.println("Number of entries: " + bb.getNumberOfEntries());
    System.out.println("Returned number of entries: " + bb.getEntries().length);
    System.out.println("First returned entry: " + bb.getEntries()[0].toString());
    System.out.println("Second returned entry: " + bb.getEntries()[1].toString());
    System.out.println("Third returned entry: " + bb.getEntries()[2].toString());

    System.out.println("(16)----------------------------------------");
    System.out.println(bb.toString());

    System.out.println("(17)----------------------------------------");
    System.out.println("Name A exists in book: " + bb.nameExists("A"));
    System.out.println("Name B exists in book: " + bb.nameExists("B"));
    System.out.println("Name C exists in book: " + bb.nameExists("C"));

    System.out.println("(18)----------------------------------------");
    bdOfA = bb.getBirthday("A");
    bdOfB = bb.getBirthday("B");
    bdOfC = bb.getBirthday("C");
    /* Birthdays of existing names are not nulls */
    System.out.println("Birthday of A: " + bdOfA.toString()); 
    System.out.println("Birthday of B: " + bdOfB.toString());
    System.out.println("Birthday of C: " + bdOfC.toString());

    System.out.println("(19)----------------------------------------");
    /* Return names of persons whose birthdays are January 16. 
     * No entries added so far have this birthday. 
     */
    toRemind = bb.getReminders(1, 16);
    System.out.println("Number of reminders of January 16: " + toRemind.length);

    System.out.println("(20)----------------------------------------");
    toRemind = bb.getReminders(1, 11);
    /* Return names of persons whose birthdays are January 11. 
     * One entry added so far has this birthday. 
     */
    System.out.println("Number of reminders of January 11: " + toRemind.length);
    System.out.println("First person to remind: " + toRemind[0]);

    System.out.println("(21)----------------------------------------");
    toRemind = bb.getReminders(6, 16);
    /* Return names of persons whose birthdays are June 16. 
     * Two entries added so far have this birthday. 
     */
    System.out.println("Number of reminders of June 16: " + toRemind.length);
    System.out.println("First person to remind: " + toRemind[0]);
    System.out.println("Secon person to remind: " + toRemind[1]);

    System.out.println("(22)----------------------------------------");
    /* removing non-existing name: no effect */ 
    bb.removeEntry("D");
    System.out.println(bb.toString());

    System.out.println("(23)----------------------------------------");
    /* removing existing name: remove the associated entry */
    bb.removeEntry("A");
    System.out.println(bb.toString());

    System.out.println("(24)----------------------------------------");
    toRemind = bb.getReminders(1, 11);
    /* After the entry associated with "A" is deleted, 
     * no entries added so far have this birthday. 
     */
    System.out.println("Number of reminders of January 11: " + toRemind.length); 

    System.out.println("(25)----------------------------------------");
    /* removing existing name: remove the associated entry */
    bb.removeEntry("C");
    System.out.println(bb.toString());

    System.out.println("(26)----------------------------------------");
    System.out.println("B's birthday: " + bb.getBirthday("B").toString());
    System.out.println("C's birthday: " + bb.getBirthday("C"));

    System.out.println("(27)----------------------------------------");
    Birthday bd = new Birthday(6, 16);
    toRemind = bb.getReminders(bd);
    /* After the entry associated with "C" is deleted, 
     * only the entry associated with "B" has this birthday. 
     */
    System.out.println("Number of reminders of June 16: " + toRemind.length);
    System.out.println("First person to remind: " + toRemind[0]);

    System.out.println("(28)----------------------------------------");
    bb.addEntry("D", bd04);
    bb.addEntry("E", 9, 19);
    System.out.println(bb.toString());

    System.out.println("(29)----------------------------------------");
    toRemind = bb.getReminders(bd04);
    System.out.println("Number of reminders for bd04: " + toRemind.length);
    System.out.println("First person to remind: " + toRemind[0]);

    System.out.println("(30)----------------------------------------");
    /* Adding an entry whose name already exists 
     * replaces the associated entry's birthday. 
     */
    bb.addEntry("E", 04, 14);
    System.out.println(bb.toString());

    System.out.println("(31)----------------------------------------");
    toRemind = bb.getReminders(4, 14);
    System.out.println("Number of reminders for April 14: " + toRemind.length);
    System.out.println("First person to remind: " + toRemind[0]);
    System.out.println("Second person to remind: " + toRemind[1]);

    System.out.println("(32)----------------------------------------");
    /* Non-empty and empty books are not equal. */
    BirthdayBook bb2 = new BirthdayBook();
    System.out.println("bb and bb2 are equal: " + bb.equals(bb2));

    System.out.println("(33)----------------------------------------");
    /* Non-empty books of different sizes are not equal. */
    bb2.addEntry("B", 6, 16);
    bb2.addEntry("D", 4, 14);
    System.out.println("bb and bb2 are equal: " + bb.equals(bb2));

    System.out.println("(34)----------------------------------------");
    /* Non-empty books, 
     * of same sizes and where entries at corresponding positions are equal, 
     * are equal. 
     */
    bb2.addEntry("E", bd04);
    System.out.println("bb and bb2 are equal: " + bb.equals(bb2));

    System.out.println("(35)----------------------------------------");
    /* Non-empty books of different sizes are not equal. */
    bb2.addEntry("F", 10, 15);
    System.out.println("bb and bb2 are equal: " + bb.equals(bb2));
  }
}