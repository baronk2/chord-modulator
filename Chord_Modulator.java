import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class Chord_Modulator {

   public enum NaturalSharpFlat {
   
      NATURAL,
      SHARP,
      FLAT
   
   }

   public enum Mode {
      
      MAJOR,
      MINOR
   
   }

   public enum Key {
     
      C,
      D,
      E,
      F,
      G,
      A,
      B,
      
      CSHARP,
      DSHARP,
      ESHARP,
      FSHARP,
      GSHARP,
      ASHARP,
      BSHARP,
      
      CFLAT,
      DFLAT,
      EFLAT,
      FFLAT,
      GFLAT,
      AFLAT,
      BFLAT,
      
      CMINOR,
      DMINOR,
      EMINOR,
      FMINOR,
      GMINOR,
      AMINOR,
      BMINOR,
      
      CSHARPMINOR,
      DSHARPMINOR,
      ESHARPMINOR,
      FSHARPMINOR,
      GSHARPMINOR,
      ASHARPMINOR,
      BSHARPMINOR,
      
      CFLATMINOR,
      DFLATMINOR,
      EFLATMINOR,
      FFLATMINOR,
      GFLATMINOR,
      AFLATMINOR,
      BFLATMINOR
      
   }
   
   public static String keyModeString(String keyString) {
      
      String keyModeString = "Major";
      
      if (keyString.substring(keyString.length() - 1).equals("m")) {
                  
         keyModeString = "Minor";
         
      }   
   
      return keyModeString;
   
   }
   
   public static Mode keyModeEnum(String keyString) {
      
      Mode keyModeEnum = Mode.MAJOR;
      
      if (keyString.substring(keyString.length() - 1).equals("m")) {
                  
         keyModeEnum = Mode.MINOR;
         
      }   
   
      return keyModeEnum;
   
   }
   
   public static String keyNoteString(String keyString) {
   
      String keyNoteString = "";
      
      if (keyString.substring(keyString.length() - 1).equals("m")) {
                  
         keyNoteString = keyString.substring(0, keyString.indexOf("m"));
         
      } else {
      
         keyNoteString = keyString;
      
      }
      
      return keyNoteString;
   
   }
   
   public static int keyChromaticNoteDegree(String keyString) {
   
      String keyNoteString = keyNoteString(keyString);
      
      int keyChromaticNoteDegree = 0;
                  
      if (keyNoteString.equals("C") || keyNoteString.equals("B#")) {
      
         keyChromaticNoteDegree = 0;
      
      } else if (keyNoteString.equals("C#") || keyNoteString.equals("Db")) {
      
         keyChromaticNoteDegree = 1;
      
      } else if (keyNoteString.equals("D")) {
      
         keyChromaticNoteDegree = 2;
      
      } else if (keyNoteString.equals("D#") || keyNoteString.equals("Eb")) {
      
         keyChromaticNoteDegree = 3;
      
      } else if (keyNoteString.equals("E") || keyNoteString.equals("Fb")) {
      
         keyChromaticNoteDegree = 4;
      
      } else if (keyNoteString.equals("E#") || keyNoteString.equals("F")) {
      
         keyChromaticNoteDegree = 5;
      
      } else if (keyNoteString.equals("F#") || keyNoteString.equals("Gb")) {
      
         keyChromaticNoteDegree = 6;
      
      } else if (keyNoteString.equals("G")) {
      
         keyChromaticNoteDegree = 7;
      
      } else if (keyNoteString.equals("G#") || keyNoteString.equals("Ab")) {
      
         keyChromaticNoteDegree = 8;
      
      } else if (keyNoteString.equals("A")) {
      
         keyChromaticNoteDegree = 9;
      
      } else if (keyNoteString.equals("A#") || keyNoteString.equals("Bb")) {
      
         keyChromaticNoteDegree = 10;
      
      } else if (keyNoteString.equals("B") || keyNoteString.equals("Cb")) {
      
         keyChromaticNoteDegree = 11;
      
      }
      
      return keyChromaticNoteDegree;
   
   }
   
   public static int chordChromaticNoteDegree(String chordString) {
   
      String chordRootNote = chordRootNote(chordString);
      
      int chordChromaticNoteDegree = 0;
                  
      if (chordRootNote.equals("C") || chordRootNote.equals("B#")) {
      
         chordChromaticNoteDegree = 0;
      
      } else if (chordRootNote.equals("C#") || chordRootNote.equals("Db")) {
      
         chordChromaticNoteDegree = 1;
      
      } else if (chordRootNote.equals("D")) {
      
         chordChromaticNoteDegree = 2;
      
      } else if (chordRootNote.equals("D#") || chordRootNote.equals("Eb")) {
      
         chordChromaticNoteDegree = 3;
      
      } else if (chordRootNote.equals("E") || chordRootNote.equals("Fb")) {
      
         chordChromaticNoteDegree = 4;
      
      } else if (chordRootNote.equals("E#") || chordRootNote.equals("F")) {
      
         chordChromaticNoteDegree = 5;
      
      } else if (chordRootNote.equals("F#") || chordRootNote.equals("Gb")) {
      
         chordChromaticNoteDegree = 6;
      
      } else if (chordRootNote.equals("G")) {
      
         chordChromaticNoteDegree = 7;
      
      } else if (chordRootNote.equals("G#") || chordRootNote.equals("Ab")) {
      
         chordChromaticNoteDegree = 8;
      
      } else if (chordRootNote.equals("A")) {
      
         chordChromaticNoteDegree = 9;
      
      } else if (chordRootNote.equals("A#") || chordRootNote.equals("Bb")) {
      
         chordChromaticNoteDegree = 10;
      
      } else if (chordRootNote.equals("B") || chordRootNote.equals("Cb")) {
      
         chordChromaticNoteDegree = 11;
      
      }
      
      return chordChromaticNoteDegree;
   
   }

   
   public static NaturalSharpFlat keyNaturalSharpFlat(String keyString) {
      
      String keyNoteString = keyNoteString(keyString);
      
      NaturalSharpFlat naturalSharpFlat = NaturalSharpFlat.NATURAL;
      
      if (keyString.equals("C") || keyString.equals("Am")) {
      
         naturalSharpFlat = NaturalSharpFlat.NATURAL;
      
      } else if (keyString.equals("B#") ||
                 keyString.equals("C#") ||
                 keyString.equals("D") ||
                 keyString.equals("D#") ||
                 keyString.equals("E") ||
                 keyString.equals("E#") ||
                 keyString.equals("F#") ||
                 keyString.equals("G") ||
                 keyString.equals("G#") ||
                 keyString.equals("A") ||
                 keyString.equals("A#") ||
                 keyString.equals("B") ||
                 keyString.equals("G##m") ||
                 keyString.equals("A#m") ||
                 keyString.equals("Bm") ||
                 keyString.equals("B#m") ||
                 keyString.equals("C#m") ||
                 keyString.equals("C##m") ||
                 keyString.equals("D#m") ||
                 keyString.equals("Em") ||
                 keyString.equals("E#m") ||
                 keyString.equals("F#m") ||
                 keyString.equals("F##m") ||
                 keyString.equals("G#m")) {
      
         naturalSharpFlat = NaturalSharpFlat.SHARP;
      
      } else if (keyString.equals("Dbb") ||
                 keyString.equals("Db") ||
                 keyString.equals("Ebb") ||
                 keyString.equals("Eb") ||
                 keyString.equals("Fb") ||
                 keyString.equals("F") ||
                 keyString.equals("Gb") ||
                 keyString.equals("Abb") ||
                 keyString.equals("Ab") ||
                 keyString.equals("Bbb") ||
                 keyString.equals("Bb") ||
                 keyString.equals("Cb") ||
                 keyString.equals("Bbbm") ||
                 keyString.equals("Bbm") ||
                 keyString.equals("Cbm") ||
                 keyString.equals("Cm") ||
                 keyString.equals("Dbm") ||
                 keyString.equals("Dm") ||
                 keyString.equals("Ebm") ||
                 keyString.equals("Fbm") ||
                 keyString.equals("Fm") ||
                 keyString.equals("Gbm") ||
                 keyString.equals("Gm") ||
                 keyString.equals("Abm")) {
      
         naturalSharpFlat = NaturalSharpFlat.FLAT;
      
      }
      
      return naturalSharpFlat;
   
   }
   
   public static String chordRootNote(String chordString) {
      
      String chordRootNote = "";
      String chordIndexCharacter = "";
      
      for (int chordIndex = 0; chordIndex < chordString.length(); chordIndex++) {
         
         chordIndexCharacter = chordString.substring(chordIndex, chordIndex + 1);
         
         if (chordIndexCharacter.equals("A") ||
             chordIndexCharacter.equals("B") ||
             chordIndexCharacter.equals("C") ||
             chordIndexCharacter.equals("D") ||
             chordIndexCharacter.equals("E") ||
             chordIndexCharacter.equals("F") ||
             chordIndexCharacter.equals("G") ||
             chordIndexCharacter.equals("#") ||
             chordIndexCharacter.equals("b")) {
         
            chordRootNote = chordRootNote + chordIndexCharacter;
         
         } else {
         
            chordIndex = chordString.length();
         
         }
      
      }
      
      return chordRootNote;
   
   }
   
   public static String chordType(String chordString) {
   
      return chordString.replaceAll(chordRootNote(chordString), "");
   
   }
   
   public static String chordRootNoteForm(int chordChromaticNoteDegree, NaturalSharpFlat keyNaturalSharpFlat) {
   
      String chordRootNote = "";
      
      if (keyNaturalSharpFlat == NaturalSharpFlat.NATURAL) {
      
         if (chordChromaticNoteDegree == 0) {
         
            chordRootNote = "C";
         
         } else if (chordChromaticNoteDegree == 9) {
         
            chordRootNote = "A";
         
         }
      
      } else if (keyNaturalSharpFlat == NaturalSharpFlat.SHARP) {
      
         if (chordChromaticNoteDegree == 0) {
         
            chordRootNote = "B#";
         
         } else if (chordChromaticNoteDegree == 1) {
         
            chordRootNote = "C#";
            
         } else if (chordChromaticNoteDegree == 2) {
         
            chordRootNote = "D";
            
         } else if (chordChromaticNoteDegree == 3) {
         
            chordRootNote = "D#";
            
         } else if (chordChromaticNoteDegree == 4) {
         
            chordRootNote = "E";
            
         } else if (chordChromaticNoteDegree == 5) {
         
            chordRootNote = "E#";
            
         } else if (chordChromaticNoteDegree == 6) {
         
            chordRootNote = "F#";
            
         } else if (chordChromaticNoteDegree == 7) {
         
            chordRootNote = "G";
            
         } else if (chordChromaticNoteDegree == 8) {
         
            chordRootNote = "G#";
            
         } else if (chordChromaticNoteDegree == 9) {
         
            chordRootNote = "A";
            
         } else if (chordChromaticNoteDegree == 10) {
         
            chordRootNote = "A#";
            
         } else if (chordChromaticNoteDegree == 11) {
         
            chordRootNote = "B";
            
         }
      
      } else if (keyNaturalSharpFlat == NaturalSharpFlat.FLAT) {
      
         if (chordChromaticNoteDegree == 0) {
         
            chordRootNote = "Dbb";
         
         } else if (chordChromaticNoteDegree == 1) {
         
            chordRootNote = "Db";
            
         } else if (chordChromaticNoteDegree == 2) {
         
            chordRootNote = "Ebb";
            
         } else if (chordChromaticNoteDegree == 3) {
         
            chordRootNote = "Eb";
            
         } else if (chordChromaticNoteDegree == 4) {
         
            chordRootNote = "Fb";
            
         } else if (chordChromaticNoteDegree == 5) {
         
            chordRootNote = "F";
            
         } else if (chordChromaticNoteDegree == 6) {
         
            chordRootNote = "Gb";
            
         } else if (chordChromaticNoteDegree == 7) {
         
            chordRootNote = "Abb";
            
         } else if (chordChromaticNoteDegree == 8) {
         
            chordRootNote = "Ab";
            
         } else if (chordChromaticNoteDegree == 9) {
         
            chordRootNote = "Bbb";
            
         } else if (chordChromaticNoteDegree == 10) {
         
            chordRootNote = "Bb";
            
         } else if (chordChromaticNoteDegree == 11) {
         
            chordRootNote = "Cb";
            
         }
      
      }
      
      return chordRootNote;
   
   }
   
   public static void main(String[] args) throws FileNotFoundException {
      
      try {
         
         String chordFileWithDirectoryString =
         "E:\\Kevin\\Music\\Chord_Numerifier\\Rocket_Man,_Elton_John,_Original_Chords.txt";
         
         File chordFile = new File(chordFileWithDirectoryString);
         Scanner chordFileScanner = new Scanner(chordFile);
         
         String chordFileNameString = chordFileWithDirectoryString.substring(
            chordFileWithDirectoryString.lastIndexOf("\\") + 1
         );
         
         String songNameAndArtistName = chordFileNameString.substring(
            0, chordFileNameString.indexOf(",_Original_Chords.txt")
         );
         
         String songName = songNameAndArtistName.substring(
            0, songNameAndArtistName.lastIndexOf(",_")
         ).replaceAll("_", " ");
        
         String artistName = songNameAndArtistName.substring(
            songNameAndArtistName.lastIndexOf(",_") + 2
         ).replaceAll("_", " ");
                  
         String currentReadLine = "";
         int currentReadLineLength = 0;
         String currentReadLineNoSpaces = "";
         int nonSpaceCharsInCurrentReadLine = 0;
         int spacesInCurrentReadLine = 0;
         
         String currentPrintLine = "";
         
         String readChordString = "";
         String writeChordString = "";
         
         int readChordStringLength = 0;
         int writeChordStringLength = 0;
         int spaceDifferenceToMakeUp = 0;
         
         String readChordRootNote = "";
         String chordType = "";
         
         String writeChordRootNote = "";
         
         int readChordChromaticNoteDegree = 0;
         int writeChordChromaticNoteDegree = 0;
         
         Key keyEnum = Key.C;
         String keyString = "C";
         String keyNoteString = "C";
         int keyChromaticNoteDegree = 0;
         NaturalSharpFlat keyNaturalSharpFlat = NaturalSharpFlat.NATURAL;
         Mode modeEnum = Mode.MAJOR;
         String modeString = "Major";
         
         
         int capoInt = 0;
         int writtenKeyChromaticNoteDegree = 0;
         
         boolean isChordLine = false;
         
         while (chordFileScanner.hasNextLine()) {
            
            currentReadLine = chordFileScanner.nextLine();
            
            currentReadLineLength = currentReadLine.length();
                        
            if (currentReadLineLength > 5) {
            
               if(currentReadLine.substring(0, 5).equals("Key: ")) {
               
                  keyString = currentReadLine.substring(5);
                  
                  keyNoteString = keyNoteString(keyString);
                  
                  keyChromaticNoteDegree = keyChromaticNoteDegree(keyString);
                  
                  keyNaturalSharpFlat = keyNaturalSharpFlat(keyString);
                  
                  modeEnum = keyModeEnum(keyString);
                  
                  modeString = keyModeString(keyString);
                                 
               }
                           
            }
            
            if (currentReadLineLength > 6) {
            
               if(currentReadLine.substring(0, 6).equals("Capo: ")) {
               
                  capoInt = Integer.parseInt(currentReadLine.substring(6, 7));
                                 
               }
                           
            }
            
            writtenKeyChromaticNoteDegree = (keyChromaticNoteDegree - capoInt) % 12;
            
            currentReadLineNoSpaces = currentReadLine.replaceAll(" ", "");
            
            nonSpaceCharsInCurrentReadLine = currentReadLineNoSpaces.length();
            
            spacesInCurrentReadLine = currentReadLineLength - nonSpaceCharsInCurrentReadLine;
            
            currentPrintLine = currentReadLine;
            
            
            if ((spacesInCurrentReadLine > (1.5 * nonSpaceCharsInCurrentReadLine))
            && (nonSpaceCharsInCurrentReadLine > 0)) {
            
               isChordLine = true;
               
               currentPrintLine = "";
               
               for (int chordLineIndex = 0; chordLineIndex < currentReadLineLength; chordLineIndex++) {
                  
                  if (currentReadLine.substring(chordLineIndex, chordLineIndex + 1).equals(" ")) {
                  
                     if (spaceDifferenceToMakeUp == 0) {
                        
                        currentPrintLine = currentPrintLine + " ";
                     
                     } else if (spaceDifferenceToMakeUp > 0) {
                     
                        spaceDifferenceToMakeUp--;
                     
                     } else if (spaceDifferenceToMakeUp < 0) {
                        
                        if (chordLineIndex + 2 < currentReadLineLength &&
                        currentReadLine.substring(chordLineIndex + 1, chordLineIndex + 2).equals(" ")) {
                        
                           currentPrintLine = currentPrintLine + "  ";
                           
                           spaceDifferenceToMakeUp++;
                        
                        }
                     
                     }
                  
                  } else if (currentReadLine.substring(chordLineIndex, chordLineIndex + 1).equals("/")) {
                  
                     currentPrintLine = currentPrintLine + "/";
                  
                  } else {
                     
                     readChordString = "";
                     writeChordString = "";
                     
                     chordType = "";
                     
                     readChordStringLength = 0;
                     writeChordStringLength = 0;
                     spaceDifferenceToMakeUp = 0;
                     int readChordIndex = 0;
                     
                     for (readChordIndex = chordLineIndex; readChordIndex < currentReadLineLength &&
                     !currentReadLine.substring(readChordIndex, readChordIndex + 1).equals(" ") &&
                     !currentReadLine.substring(readChordIndex, readChordIndex + 1).equals("/");
                     readChordIndex++) {
                     
                        readChordString = readChordString + currentReadLine.substring(readChordIndex,
                        readChordIndex + 1);
                     
                     }
                     
                     readChordRootNote = chordRootNote(readChordString);
                     
                     chordType = chordType(readChordString);
                     
                     readChordChromaticNoteDegree = chordChromaticNoteDegree(readChordRootNote);
                     
                     writeChordChromaticNoteDegree = ((readChordChromaticNoteDegree - capoInt) + 12) % 12;
                     
                     writeChordRootNote = chordRootNoteForm(writeChordChromaticNoteDegree, keyNaturalSharpFlat);
                     
                     writeChordString = writeChordRootNote + chordType;
                     
                     
                     
                     currentPrintLine = currentPrintLine + writeChordString;
                     
                     readChordStringLength = readChordString.length();
                     
                     writeChordStringLength = writeChordString.length();
                     
                     spaceDifferenceToMakeUp = writeChordStringLength - readChordStringLength;
                     
                     chordLineIndex = readChordIndex - 1;
                                         
                  }
                  
               }
               
               //Comment out or delete for modulated chords only.
               System.out.println(currentReadLine);
            
            } else {
            
               isChordLine = false;
            
            }    
            
            System.out.println(currentPrintLine);
            spaceDifferenceToMakeUp = 0;
            //System.out.println("isChordLine: " + isChordLine);
                     
         }
         
         System.out.println();
         System.out.println("songName: " + songName);
         System.out.println("artistName: " + artistName);
         System.out.println();
         System.out.println("keyString: " + keyString);
         System.out.println("keyChromaticNoteDegree: " + keyChromaticNoteDegree);
         System.out.println("modeEnum: " + modeEnum.name());
         System.out.println("modeString: " + modeString);
         System.out.println("keyNaturalSharpFlat: " + keyNaturalSharpFlat.name());
         System.out.println();
         System.out.println("capoInt: " + capoInt);
         System.out.println("writtenKeyChromaticNoteDegree: " + writtenKeyChromaticNoteDegree);
               
      } catch (FileNotFoundException exception) {
      
         System.out.println("Chord file not found.");
      
      }

   }
     
}