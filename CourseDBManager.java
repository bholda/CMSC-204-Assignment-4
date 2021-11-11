import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {
        private CourseDBStructure CDS = new CourseDBStructure(20);
        @Override
        public void readFile(File given) throws FileNotFoundException {
                try {
                        Scanner fileData = new Scanner(given);
                        while(fileData.hasNext()) {
                                String id = fileData.next();
                                int crn = fileData.nextInt();
                                int creditNumber = fileData.nextInt();
                                String roomNumber = fileData.next();
                                String professor = fileData.nextLine();
                                add(id, crn, creditNumber, roomNumber, professor);
                        }
                        fileData.close();
                }
                catch(FileNotFoundException a) {
                        System.out.print("File not found");
                        a.getMessage();
                }
        }
        @Override
        public void add(String id, int crn, int creditNumber, String roomNumber, String professor) {
                CourseDBElement newElement = new CourseDBElement(id, crn, creditNumber, roomNumber, professor);
                CDS.add(newElement);
        }
        
        @Override
        public CourseDBElement get(int crn) {
                try {
                        return CDS.get(crn);
                } catch (IOException a) {
                        a.getMessage();
                }
                return null;
        }
        @Override
        public ArrayList<String> showAll() {
                ArrayList<String> list = new ArrayList<String>();
                for (int a = 0; a < CDS.hashTable.length; a++) { 
                        LinkedList<CourseDBElement> tempList = CDS.hashTable[a];
                        if(tempList != null) {
                                for(int i = 0; i < tempList.size(); i++) { 
                                        CourseDBElement element = tempList.get(i);
                                        list.add(element.toString());
                                }
                        }
                }
                return list;
        }
}