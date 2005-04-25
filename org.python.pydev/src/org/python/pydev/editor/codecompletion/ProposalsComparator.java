/*
 * Created on Sep 14, 2004
 *
 * @author Fabio Zadrozny
 */
package org.python.pydev.editor.codecompletion;

import java.util.Comparator;

import org.eclipse.jface.text.contentassist.ICompletionProposal;

/**
 * @author Fabio Zadrozny
 */
public class ProposalsComparator implements Comparator {

    public int compare(Object o1, Object o2) {
        
        if(o1 instanceof IPyCompletionProposal && o2 instanceof IPyCompletionProposal){
	        IPyCompletionProposal p1 = (IPyCompletionProposal) o1;
	        IPyCompletionProposal p2 = (IPyCompletionProposal) o2;
            
	        if(p1.getPriority() < p2.getPriority()){
	            return -1;
	        }
	        if(p1.getPriority() > p2.getPriority()){
	            return 1;
	        }
        }
        //if it is not an IPyCompletionProposal, it has default priority.
        if(o1 instanceof IPyCompletionProposal){
	        IPyCompletionProposal p1 = (IPyCompletionProposal) o1;
            
	        if(p1.getPriority() < IPyCompletionProposal.PRIORITY_DEFAULT){
	            return -1;
	        }
	        if(p1.getPriority() > IPyCompletionProposal.PRIORITY_DEFAULT){
	            return 1;
	        }
        }
        
        if(o2 instanceof IPyCompletionProposal){
	        IPyCompletionProposal p2 = (IPyCompletionProposal) o2;
            
	        if(IPyCompletionProposal.PRIORITY_DEFAULT < p2.getPriority()){
	            return -1;
	        }
	        if(IPyCompletionProposal.PRIORITY_DEFAULT > p2.getPriority()){
	            return 1;
	        }
        }
        
        
        
        
        ICompletionProposal p1 = (ICompletionProposal) o1;
        ICompletionProposal p2 = (ICompletionProposal) o2;
        
        return p1.getDisplayString().compareToIgnoreCase(p2.getDisplayString());
    }

}
