package gg.moonflower.etched.client.render.item;

import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;

public class AlbumImageModelLoadingPlugin implements ModelLoadingPlugin {
	@Override
	public void onInitializeModelLoader(Context pluginContext) {
		ResourceManager resourceManager = Minecraft.getInstance().getResourceManager();
		String folder = "models/item/" + AlbumCoverItemRenderer.FOLDER_NAME;
		for (ResourceLocation location : resourceManager.listResources(folder, name -> name.getPath().endsWith(".json")).keySet()) {
			pluginContext.addModels(new ModelResourceLocation(new ResourceLocation(location.getNamespace(), location.getPath().substring(12, location.getPath().length() - 5)), "inventory"));
		}
	}
}
