package tas.controller;
import tas.model.StartseiteModell;
import tas.navigation.NavigationsHandler;
import tas.view.StartseiteView;

public class StartseiteController {

    private final StartseiteModell modell;
    private final StartseiteView ansicht;
    private final NavigationsHandler navigation;

    public StartseiteController(StartseiteModell modell,
                                StartseiteView ansicht,
                                NavigationsHandler navigation) {
        this.modell = modell;
        this.ansicht = ansicht;
        this.navigation = navigation;

        initialisiereTexte();
        verknuepfeAktionen();
    }

    private void initialisiereTexte() {
        ansicht.setTitel(modell.getTitel());
        ansicht.setSlogan(modell.getSlogan());

        ansicht.getFrageButton().setText(modell.getFrageModus());
        ansicht.getQuizButton().setText(modell.getQuizModus());
        ansicht.getSpieleButton().setText(modell.getSpieleModus());
        ansicht.getEditorButton().setText(modell.getEditor());
    }

    private void verknuepfeAktionen() {
        ansicht.getFrageButton()
                .addActionListener(e -> navigation.oeffneFrageModus());
        ansicht.getQuizButton()
                .addActionListener(e -> navigation.oeffneQuizModus());
        ansicht.getSpieleButton()
                .addActionListener(e -> navigation.oeffneSpieleModus());
        ansicht.getEditorButton()
                .addActionListener(e -> navigation.oeffneFragenpoolEditor());
    }

    public StartseiteView getAnsicht() {
        return ansicht;
    }
}
