package com.lastabyss.carbon.commands;

import java.util.List;

import net.minecraft.server.v1_7_R4.ChatMessage;
import net.minecraft.server.v1_7_R4.ChunkCoordinates;
import net.minecraft.server.v1_7_R4.CommandAbstract;
import net.minecraft.server.v1_7_R4.CommandException;
import net.minecraft.server.v1_7_R4.ExceptionUsage;
import net.minecraft.server.v1_7_R4.ICommandListener;
import net.minecraft.server.v1_7_R4.Position;
import net.minecraft.util.com.google.common.primitives.Doubles;

public class WorldBorderCommand extends CommandAbstract {
	public static WorldBorder worldBorder = new WorldBorder();

	public String getCommand() {
		return "worldborder";
	}

	public int a() {
		return 2;
	}

	public String c(ICommandListener var1) {
		return "commands.worldborder.usage";
	}

	public void execute(ICommandListener var1, String[] var2)
			throws ExceptionUsage, CommandException {
		if (var2.length < 1) {
                    
			throw new ExceptionUsage("commands.worldborder.usage",
					new Object[0]);
		} else {
			WorldBorder var3 = this.d();
			double var4;
			double var6;
			long var8;
			if (var2[0].equals("set")) {
				if (var2.length != 2 && var2.length != 3) {
					throw new ExceptionUsage("commands.worldborder.set.usage",
							new Object[0]);
				}
				var4 = var3.getCurrentRadius();
				var6 = a(var2[1], 1.0D, 6.0E7D);
				var8 = (var2.length > 2 ? a(var2[2], 0L, 9223372036854775L) * 1000L
						: 0L);
				if (var8 > 0L) {
					var3.changeSize(var4, var6, var8);
					if (var4 > var6) {
						a(var1,
								this,
								"commands.worldborder.setSlowly.shrink.success",
								new Object[] {
										String.format("%.1f",
												new Object[] { Double
														.valueOf(var6) }),
										String.format("%.1f",
												new Object[] { Double
														.valueOf(var4) }),
										Long.toString(var8 / 1000L) });
					} else {
						a(var1,
								this,
								"commands.worldborder.setSlowly.grow.success",
								new Object[] {
										String.format("%.1f",
												new Object[] { Double
														.valueOf(var6) }),
										String.format("%.1f",
												new Object[] { Double
														.valueOf(var4) }),
										Long.toString(var8 / 1000L) });
					}
				} else {
					var3.setSize(var6);
					a(var1,
							this,
							"commands.worldborder.set.success",
							new Object[] {
									String.format(
											"%.1f",
											new Object[] { Double.valueOf(var6) }),
									String.format(
											"%.1f",
											new Object[] { Double.valueOf(var4) }) });
				}
			} else if (var2[0].equals("add")) {
				if (var2.length != 2 && var2.length != 3) {
					throw new ExceptionUsage("commands.worldborder.add.usage",
							new Object[0]);
				}
				var4 = var3.getOldRadius();
				var6 = var4 + a(var2[1], -var4, 6.0E7D - var4);
				var8 = var3.getSpeed()
						+ (var2.length > 2 ? a(var2[2], 0L, 9223372036854775L) * 1000L
								: 0L);
				if (var8 > 0L) {
					var3.changeSize(var4, var6, var8);
					if (var4 > var6) {
						a(var1,
								this,
								"commands.worldborder.setSlowly.shrink.success",
								new Object[] {
										String.format("%.1f",
												new Object[] { Double
														.valueOf(var6) }),
										String.format("%.1f",
												new Object[] { Double
														.valueOf(var4) }),
										Long.toString(var8 / 1000L) });
					} else {
						a(var1,
								this,
								"commands.worldborder.setSlowly.grow.success",
								new Object[] {
										String.format("%.1f",
												new Object[] { Double
														.valueOf(var6) }),
										String.format("%.1f",
												new Object[] { Double
														.valueOf(var4) }),
										Long.toString(var8 / 1000L) });
					}
				} else {
					var3.setSize(var6);
					a(var1,
							this,
							"commands.worldborder.set.success",
							new Object[] {
									String.format(
											"%.1f",
											new Object[] { Double.valueOf(var6) }),
									String.format(
											"%.1f",
											new Object[] { Double.valueOf(var4) }) });
				}
			} else if (var2[0].equals("center")) {
				if (var2.length != 3) {
					throw new ExceptionUsage(
							"commands.worldborder.center.usage", new Object[0]);
				}
				ChunkCoordinates var10 = var1.getChunkCoordinates();
				double var5 = b((double) var10.x + 0.5D, var2[1], true);
				double var7 = b((double) var10.z + 0.5D, var2[2], true);
				var3.setCenter(var5, var7);
				a(var1,
						this,
						"commands.worldborder.center.success",
						new Object[] { Double.valueOf(var5),
								Double.valueOf(var7) });
			} else if (var2[0].equals("damage")) {
				if (var2.length < 2) {
					throw new ExceptionUsage(
							"commands.worldborder.damage.usage", new Object[0]);
				}
				if (var2[1].equals("buffer")) {
					if (var2.length != 3) {
						throw new ExceptionUsage(
								"commands.worldborder.damage.buffer.usage",
								new Object[0]);
					}
					var4 = a(var2[2], 0.0D);
					var6 = var3.getDamageBuffer();
					var3.setDamageBuffer(var4);
					a(var1,
							this,
							"commands.worldborder.damage.buffer.success",
							new Object[] {
									String.format(
											"%.1f",
											new Object[] { Double.valueOf(var4) }),
									String.format(
											"%.1f",
											new Object[] { Double.valueOf(var6) }) });
				} else if (var2[1].equals("amount")) {
					if (var2.length != 3) {
						throw new ExceptionUsage(
								"commands.worldborder.damage.amount.usage",
								new Object[0]);
					}
					var4 = a(var2[2], 0.0D);
					var6 = var3.getDamageAmount();
					var3.setDamageAmount(var4);
					a(var1,
							this,
							"commands.worldborder.damage.amount.success",
							new Object[] {
									String.format(
											"%.2f",
											new Object[] { Double.valueOf(var4) }),
									String.format(
											"%.2f",
											new Object[] { Double.valueOf(var6) }) });
				}
			} else if (var2[0].equals("warning")) {
				if (var2.length < 2) {
					throw new ExceptionUsage(
							"commands.worldborder.warning.usage", new Object[0]);
				}
				int var11 = a(var2[2], 0);
				int var12;
				if (var2[1].equals("time")) {
					if (var2.length != 3) {
						throw new ExceptionUsage(
								"commands.worldborder.warning.time.usage",
								new Object[0]);
					}
					var12 = var3.getWarningTime();
					var3.setWarningTime(var11);
					a(var1,
							this,
							"commands.worldborder.warning.time.success",
							new Object[] { Integer.valueOf(var11),
									Integer.valueOf(var12) });
				} else if (var2[1].equals("distance")) {
					if (var2.length != 3) {
						throw new ExceptionUsage(
								"commands.worldborder.warning.distance.usage",
								new Object[0]);
					}
					var12 = var3.getWarningBlocks();
					var3.setWarningBlocks(var11);
					a(var1,
							this,
							"commands.worldborder.warning.distance.success",
							new Object[] { Integer.valueOf(var11),
									Integer.valueOf(var12) });
				}
			} else if (var2[0].equals("get")) {
				var4 = var3.getOldRadius();
				// var1.a(this., MathHelper.f(var4 + 0.5D));
				var1.sendMessage(new ChatMessage(
						"commands.worldborder.get.success",
						new Object[] { String.format("%.0f",
								new Object[] { Double.valueOf(var4) }) }));
			}
		}
	}

	public static int a(String var0) throws CommandException {
		try {
			return Integer.parseInt(var0);
		} catch (NumberFormatException var2) {
			throw new CommandException("commands.generic.num.invalid",
					new Object[] { var0 });
		}
	}

	public static int a(String var0, int var1) throws CommandException {
		return a(var0, var1, Integer.MAX_VALUE);
	}

	public static int a(String var0, int var1, int var2)
			throws CommandException {
		int var3 = a(var0);
		if (var3 < var1) {
			throw new CommandException(
					"commands.generic.num.tooSmall",
					new Object[] { Integer.valueOf(var3), Integer.valueOf(var1) });
		} else if (var3 > var2) {
			throw new CommandException(
					"commands.generic.num.tooBig",
					new Object[] { Integer.valueOf(var3), Integer.valueOf(var2) });
		} else {
			return var3;
		}
	}

	public static double a(String var0, double var1) throws CommandException {
		return a(var0, var1, Double.MAX_VALUE);
	}

	public static double a(String var0, double var1, double var3)
			throws CommandException {
		double var5 = c(var0);
		if (var5 < var1) {
			throw new CommandException("commands.generic.double.tooSmall",
					new Object[] { Double.valueOf(var5), Double.valueOf(var1) });
		} else if (var5 > var3) {
			throw new CommandException("commands.generic.double.tooBig",
					new Object[] { Double.valueOf(var5), Double.valueOf(var3) });
		} else {
			return var5;
		}
	}

	public static double c(String var0) throws CommandException {
		try {
			double var1 = Double.parseDouble(var0);
			if (!Doubles.isFinite(var1)) {
				throw new CommandException("commands.generic.num.invalid",
						new Object[] { var0 });
			} else {
				return var1;
			}
		} catch (NumberFormatException var3) {
			throw new CommandException("commands.generic.num.invalid",
					new Object[] { var0 });
		}
	}

	public static double b(double var0, String var2, boolean var3)
			throws CommandException {
		return b(var0, var2, -30000000, 30000000, var3);
	}

	public static double b(double var0, String var2, int var3, int var4,
			boolean var5) throws CommandException {
		boolean var6 = var2.startsWith("~");
		if (var6 && Double.isNaN(var0)) {
			throw new CommandException("commands.generic.num.invalid",
					new Object[] { Double.valueOf(var0) });
		} else {
			double var7 = var6 ? var0 : 0.0D;
			if (!var6 || var2.length() > 1) {
				boolean var9 = var2.contains(".");
				if (var6) {
					var2 = var2.substring(1);
				}
				var7 += c(var2);
				if (!var9 && !var6 && var5) {
					var7 += 0.5D;
				}
			}
			if (var3 != 0 || var4 != 0) {
				if (var7 < (double) var3) {
					throw new CommandException(
							"commands.generic.double.tooSmall",
							new Object[] { Double.valueOf(var7),
									Integer.valueOf(var3) });
				}
				if (var7 > (double) var4) {
					throw new CommandException(
							"commands.generic.double.tooBig",
							new Object[] { Double.valueOf(var7),
									Integer.valueOf(var4) });
				}
			}
			return var7;
		}
	}

	public static long b(String var0) throws CommandException {
		try {
			return Long.parseLong(var0);
		} catch (NumberFormatException var2) {
			throw new CommandException("commands.generic.num.invalid", new Object[] { var0 });
		}
	}

	public static long a(String var0, long var1, long var3)
			throws CommandException {
		long var5 = b(var0);
		if (var5 < var1) {
			throw new CommandException("commands.generic.num.tooSmall",
					new Object[] { Long.valueOf(var5), Long.valueOf(var1) });
		} else if (var5 > var3) {
			throw new CommandException("commands.generic.num.tooBig",
					new Object[] { Long.valueOf(var5), Long.valueOf(var3) });
		} else {
			return var5;
		}
	}

	protected WorldBorder d() {
		return worldBorder;
	}

	public List getTabCompleteList(ICommandListener var1, String[] var2,
			Position var3) {
		return var2.length == 1 ? a(var2, new String[] { "set", "center",
				"damage", "warning", "add", "get" }) : (var2.length == 2
				&& var2[0].equals("damage") ? a(var2, new String[] { "buffer",
				"amount" })
				: (var2.length == 2 && var2[0].equals("warning") ? a(var2,
						new String[] { "time", "distance" }) : null));
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}

}