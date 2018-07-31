package uk.artdude.zenstages.stager.util;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import uk.artdude.zenstages.stager.Stage;

import java.util.UUID;

@ZenRegister
@ZenClass("mods.zenstages.Utils")
public class Utils {
    public static final String recipeString = "stage_%s_%s";
    public static final String craftTweakerRegex = String.format("%s:%s", "crafttweaker", recipeString);

    @ZenMethod
    public static String genRecipeName() {
        return UUID.randomUUID().toString();
    }

    @ZenMethod
    public static String genRecipeName(Stage stage) {
        return String.format(recipeString, formatStage(stage), UUID.randomUUID().toString());
    }

    @ZenMethod
    public static String genRecipeName(Stage stage, String name) {
        return String.format(recipeString, formatStage(stage), name);
    }

    @ZenMethod
    public static String genRecipeName(Stage stage, IItemStack itemStack) {
        return String.format(recipeString, formatStage(stage), formatItem(itemStack));
    }

    @ZenMethod
    public static String genRecipeName(Stage stage, IItemStack itemStack, String name) {
        return String.format(recipeString + "_%s", formatStage(stage), formatItem(itemStack), name);
    }

    public static String formatStage(Stage stage) {
        return stage.getStage()
                .replaceAll("\\s+", "_");
    }

    private static String formatItem(IItemStack itemStack) {
        return itemStack.getDisplayName()
                .replaceAll("\\s+", "_")
                .replaceAll("[()]", "")
                .toLowerCase();
    }
}
