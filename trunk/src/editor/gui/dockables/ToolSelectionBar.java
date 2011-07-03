package editor.gui.dockables;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Peter
 * Date: 6/24/11
 * Time: 6:16 PM
 * Computer: Peterbjornx-PC.rootdomain.asn.local (192.168.178.27)
 */
public class ToolSelectionBar {
    private JPanel mainPane;
    private JToggleButton paintOverlayButton;
    private JToggleButton paintUnderlayButton;
    private JToggleButton heighChgButton;
    private JToggleButton heightSetButton;
    private JToggleButton floodFillOButton;
    private JToggleButton applySettingsButton;
    private JToggleButton floodFillUButton;
    private JToggleButton selectButton;
    private JSlider slider1;
    private JLabel brushSizeLabel;
    private EditorTools tool = EditorTools.SELECT;

    public ToolSelectionBar() {
        ChangeListener listener = new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            public void stateChanged(ChangeEvent e) {
                if (selectButton.isSelected())
                    tool = EditorTools.SELECT;
                if (paintOverlayButton.isSelected())
                    tool = EditorTools.PAINT_OVERLAY;
                if (paintUnderlayButton.isSelected())
                    tool = EditorTools.PAINT_UNDERLAY;
                if (heighChgButton.isSelected())
                    tool = EditorTools.HEIGHT_EDIT;
                if (heightSetButton.isSelected())
                    tool = EditorTools.HEIGHT_SET;
                if (applySettingsButton.isSelected())
                    tool = EditorTools.APPLY_SETTINGS;
                if (floodFillOButton.isSelected())
                    tool = EditorTools.FLOODFILL_OVERLAY;
                if (floodFillUButton.isSelected())
                    tool = EditorTools.FLOODFILL_UNDERLAY;
                brushSizeLabel.setText(Integer.toString(slider1.getValue()));
            }
        };
        selectButton.addChangeListener(listener);
        paintOverlayButton.addChangeListener(listener);
        paintUnderlayButton.addChangeListener(listener);
        heighChgButton.addChangeListener(listener);
        heightSetButton.addChangeListener(listener);
        applySettingsButton.addChangeListener(listener);
        floodFillOButton.addChangeListener(listener);
        floodFillUButton.addChangeListener(listener);
        slider1.addChangeListener(listener);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public JPanel getMainPane() {
        return mainPane;
    }

    public EditorTools getSelectedTool() {
        return tool;
    }

    public int getBrushSize() {
        return slider1.getValue();
    }

    {
        // GUI initializer generated by IntelliJ IDEA GUI Designer
        // >>> IMPORTANT!! <<<
        // DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPane = new JPanel();
        mainPane.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 12, new Insets(0, 0, 0, 0), -1, -1));
        paintOverlayButton = new JToggleButton();
        paintOverlayButton.setText("PO");
        mainPane.add(paintOverlayButton, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(27, 25), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        mainPane.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 11, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        paintUnderlayButton = new JToggleButton();
        paintUnderlayButton.setText("PU");
        mainPane.add(paintUnderlayButton, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        heighChgButton = new JToggleButton();
        heighChgButton.setText("HM");
        mainPane.add(heighChgButton, new com.intellij.uiDesigner.core.GridConstraints(0, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        heightSetButton = new JToggleButton();
        heightSetButton.setText("HS");
        mainPane.add(heightSetButton, new com.intellij.uiDesigner.core.GridConstraints(0, 6, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        applySettingsButton = new JToggleButton();
        applySettingsButton.setText("AS");
        mainPane.add(applySettingsButton, new com.intellij.uiDesigner.core.GridConstraints(0, 7, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        selectButton = new JToggleButton();
        selectButton.setSelected(true);
        selectButton.setText("S");
        mainPane.add(selectButton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        slider1 = new JSlider();
        slider1.setMajorTickSpacing(2);
        slider1.setMaximum(24);
        slider1.setMinimum(1);
        slider1.setMinorTickSpacing(1);
        slider1.setPaintTicks(true);
        slider1.setValue(1);
        mainPane.add(slider1, new com.intellij.uiDesigner.core.GridConstraints(0, 9, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Brush size:");
        mainPane.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 8, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        brushSizeLabel = new JLabel();
        brushSizeLabel.setText("1");
        mainPane.add(brushSizeLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 10, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        floodFillOButton = new JToggleButton();
        floodFillOButton.setText("FO");
        mainPane.add(floodFillOButton, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        floodFillUButton = new JToggleButton();
        floodFillUButton.setText("FU");
        mainPane.add(floodFillUButton, new com.intellij.uiDesigner.core.GridConstraints(0, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ButtonGroup buttonGroup;
        buttonGroup = new ButtonGroup();
        buttonGroup.add(selectButton);
        buttonGroup.add(paintOverlayButton);
        buttonGroup.add(paintUnderlayButton);
        buttonGroup.add(heighChgButton);
        buttonGroup.add(heightSetButton);
        buttonGroup.add(floodFillOButton);
        buttonGroup.add(applySettingsButton);
        buttonGroup.add(floodFillUButton);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPane;
    }

    public enum EditorTools {
        PAINT_OVERLAY, PAINT_UNDERLAY, HEIGHT_EDIT, HEIGHT_SET, APPLY_SETTINGS, SELECT, FLOODFILL_OVERLAY, FLOODFILL_UNDERLAY;
    }
}
