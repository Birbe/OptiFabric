package me.modmuss50.optifabric.mod;

import net.fabricmc.loader.api.FabricLoader;

import java.io.*;
import java.net.URI;

public class OptifineVersion {


	public static String optifineVersion;
	public static String minecraftVersion;
	public static JarType jarType;

	public static File findOptifineJar() throws IOException {
		File modsDir = new File(FabricLoader.getInstance().getGameDirectory(), "mods");
		File[] mods = modsDir.listFiles();

		File optifineJar = null;

//		if (mods != null) {
//			for (File file : mods) {
//				if (file.isDirectory()) {
//					continue;
//				}
//				if (file.getName().endsWith(".jar")) {
//					JarType type = getJarType(file);
//					if (type.error) {
//						throw new RuntimeException("An error occurred when trying to find the optifine jar: " + type.name());
//					}
//					if (type == JarType.OPIFINE_MOD || type == JarType.OPTFINE_INSTALLER) {
//						if(optifineJar != null){
//							OptifabricError.setError("Found 2 or more optifine jars, please ensure you only have 1 copy of optifine in the mods folder!");
//							throw new FileNotFoundException("Multiple optifine jars");
//						}
//						jarType = type;
//						optifineJar =  file;
//					}
//				}
//			}
//		}
//
//		if(optifineJar != null){
//			return optifineJar;
//		}
//
//		OptifabricError.setError("OptiFabric could not find the Optifine jar in the mods folder.");
//		throw new FileNotFoundException("Could not find optifine jar");

		File file = new File("C:/Users/Birb/OptiFabric/run/mods/OptiFine_1.8.9_HD_U_L5.jar");

		getJarType(file);

		return file;
	}

	private static JarType getJarType(File file) throws IOException {
//		ClassNode classNode;
//		try (JarFile jarFile = new JarFile(file)) {
//			JarEntry jarEntry = jarFile.getJarEntry("Config.class"); // Old 1.8.9 location
//			if (jarEntry == null) {
//				return JarType.SOMETHINGELSE;
//			}
//			classNode = ASMUtils.asClassNode(jarEntry, jarFile);
//		}
//
//		for (FieldNode fieldNode : classNode.fields) {
//			if (fieldNode.name.equals("VERSION")) {
//				version = (String) fieldNode.value;
//			}
//			if (fieldNode.name.equals("MC_VERSION")) {
//				minecraftVersion = (String) fieldNode.value;
//			}
//		}
//
//		if (version == null || version.isEmpty() || minecraftVersion == null || minecraftVersion.isEmpty()) {
//			return JarType.INCOMPATIBLE;
//		}
//
//		String currentMcVersion = "unknown";
//		try {
//			try(InputStream is = OptifineVersion.class.getResourceAsStream("/version.json")){
//				try(InputStreamReader isr = new InputStreamReader(is)){
//					JsonObject jsonObject = new Gson().fromJson(isr, JsonObject.class);
//					currentMcVersion = jsonObject.get("name").getAsString();
//				}
//			}
//		} catch (Exception e){
//			OptifabricError.setError("Failed to find minecraft version");
//			e.printStackTrace();
//			return JarType.INCOMPATIBLE;
//		}
//
//		if (!currentMcVersion.equals(minecraftVersion)) {
//			OptifabricError.setError(String.format("This version of optifine is not compatible with the current minecraft version\n\n Optifine requires %s you have %s", minecraftVersion, currentMcVersion));
//			return JarType.INCOMPATIBLE;
//		}
//
//		Holder<Boolean> isInstaller = new Holder<>(false);
//		ZipUtil.iterate(file, (in, zipEntry) -> {
//			if (zipEntry.getName().startsWith("patch/")) {
//				isInstaller.setValue(true);
//			}
//		});
//
//		if (isInstaller.getValue()) {
//			return JarType.OPTFINE_INSTALLER;
//		} else {
//			return JarType.OPIFINE_MOD;
//		}

		minecraftVersion = "1.8.9";
		optifineVersion = "OptiFine_1.8.9_HD_U_L5"; //Optifine version

		return JarType.OPTFINE_INSTALLER;
	}

	public enum JarType {
		OPIFINE_MOD(false),
		OPTFINE_INSTALLER(false),
		INCOMPATIBLE(true),
		SOMETHINGELSE(false);

		boolean error;

		JarType(boolean error) {
			this.error = error;
		}

		public boolean isError() {
			return error;
		}
	}

	private static class Holder<T> {

		T value;

		private Holder(T value) {
			this.value = value;
		}

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}

		public static <T> Holder<T> of(T value) {
			return new Holder<>(value);
		}

	}

}
