/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notebook;


/**
 *
 * @author nihan
 */
public class Note {
    String name;
    String content;
    
    String[] getList() {
        return new String[] { "note Item 1", "Note item 2" };
    }
    
    String getContent(String name) {
        // Should return content by selected name
        return "";
    }
}
