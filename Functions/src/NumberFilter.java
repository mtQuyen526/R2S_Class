package Functions.src;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

class NumberFilter extends DocumentFilter {

    @Override
    public void insertString(FilterBypass fb, int offset,
                             String string, AttributeSet attr)
            throws BadLocationException {

        String text = fb.getDocument().getText(0,
                fb.getDocument().getLength());

        String newText = text.substring(0, offset)
                + string
                + text.substring(offset);

        if (newText.matches("-?\\d*(\\.\\d*)?")) {
            super.insertString(fb, offset, string, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset,
                        int length, String text,
                        AttributeSet attrs)
            throws BadLocationException {

        String oldText = fb.getDocument().getText(0,
                fb.getDocument().getLength());

        String newText = oldText.substring(0, offset)
                + text
                + oldText.substring(offset + length);

        if (newText.matches("-?\\d*(\\.\\d*)?")) {
            super.replace(fb, offset, length, text, attrs);
        }
    }
}