/*
 * Copyright (c) 2002-2017 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.neo4j.impl.kernel.api;

public interface EdgeTraversalCursor extends EdgeDataAccessor, SuspendableCursor<EdgeTraversalCursor.Position>
{
    abstract class Position extends CursorPosition<Position>
    {
    }

    /**
     * Get the other node, the one that this cursor was not initialized from.
     * <p>
     * Edge cursors have context, and know which node they are traversing edges for, making it possible and convenient
     * to access the other node.
     *
     * @param cursor
     *         the cursor to use for accessing the other node.
     */
    void neighbour( NodeCursor cursor );

    long neighbourNodeReference();

    long originNodeReference();
}
