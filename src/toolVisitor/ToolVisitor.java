/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package toolVisitor;

import simpledraw.CircleTool;
import simpledraw.LineTool;
import simpledraw.SelectionTool;

/**
 *
 * @author John Doe
 */
public interface ToolVisitor {
    public void visit(CircleTool c);
    public void visit(LineTool l);
    public void visit(SelectionTool s);
}
