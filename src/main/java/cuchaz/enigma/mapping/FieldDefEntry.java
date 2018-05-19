/*******************************************************************************
 * Copyright (c) 2015 Jeff Martin.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public
 * License v3.0 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 * <p>
 * Contributors:
 * Jeff Martin - initial API and implementation
 ******************************************************************************/

package cuchaz.enigma.mapping;

import com.google.common.base.Preconditions;
import cuchaz.enigma.bytecode.AccessFlags;

public class FieldDefEntry extends FieldEntry {
	private final AccessFlags access;

	public FieldDefEntry(ClassEntry ownerEntry, String name, TypeDescriptor desc, AccessFlags access) {
		super(ownerEntry, name, desc);
		Preconditions.checkNotNull(access, "Field access cannot be null");
		this.access = access;
	}

	public AccessFlags getAccess() {
		return access;
	}

	@Override
	public FieldDefEntry updateOwnership(ClassEntry owner) {
		return new FieldDefEntry(owner, this.name, this.desc, access);
	}
}
